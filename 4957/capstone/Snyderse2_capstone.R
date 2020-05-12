# ----------------------------------------------------------------------------
# Author: Shay Snyder
# Date Created: April 30, 2020
# ----------------------------------------------------------------------------
# File name: Snyderse2_capstone.R
# Project: Data Analytics Capstone
# ----------------------------------------------------------------------------

# required packages
library(dplyr)
library(VIM)
library(ggplot2)
library(arules)
library(naivebayes)
library(caret)
library(rpart)
library(rpart.plot)
library(randomForest)

preprocessData <- function()
{
  # import the 10k patients dataset
  data <- read.csv("10kPatients - slightly preprocessed.csv", header = TRUE, na.strings = c("", "?", "Not Available", "Not Mapped"))

  # lets see how many missing values we have left
  paste("The number of remaning errors before imputation", sum(is.na(data)))
  
  # lets perform kNN computation upon the dataset
  data <- kNN(data, imp_var = FALSE)
  
  # show the number of empty values after kNN imputation
  paste("The number of errors after imputation: ", sum(is.na(data)))
  
  # export the processed dataframe
  write.csv(data, "10kPatientsProcessed.csv", row.names = FALSE)
}

# this function accepts a dataframe and column argument where
# column specified the desired column to evaluate distribution
plotDist <- function(data, desiredColumn)
{
   # get the desired column from the data
  column <- data[,desiredColumn]
  
  # create the plot
  return(ggplot(data, aes(x = column)) + geom_bar())
}

# show the distibution of different variables within the dataset
visualizeData <- function()
{
    # use the dataset that hasnt't been preprocessed
    data <- read.csv("10kPatients.csv", stringsAsFactors = FALSE)
    
    # show the distribution of patients readmitted vs not readmitted
    plot1 <- plotDist(data, "readmitted")
    plot1 + labs(title = "Distribution of Patient Readmissions",
                 y = "Number of Instances",
                 x = "Was the Patient Readmitted?")
    ggsave("readmission distribution.png")
  
    # show the distribution of patients on diabetic medication
    plot2 <- plotDist(data, "diabetesMed")
    plot2 + labs(title = "Distribution of Patients on Diabetes Medicine",
                 y = "Number of Instances",
                 x = "Is the Patient on Diabetes Medicine?")
    ggsave("diabetic medication distribution.png")
    
    # show the distribution of patient race
    plot3 <- plotDist(data, "race")
    plot3 + labs(title = "Distribution of Race",
                 y = "Number of Instances",
                 x = "Race")
    ggsave("race distribution.png")
    
    # show the distribution of patient age
    plot4 <- plotDist(data, "age")
    plot4 + labs(title = "Distribution of Age",
                 y = "Number of Instances",
                 x = "Age")
    ggsave("age distribution.png")
    
    # show the distribution of patient gender
    plot5 <- plotDist(data, "gender")
    plot5 + labs(title = "Distribution of Gender",
                 y = "Number of Instances",
                 x = "Gender")
    ggsave("gender distribution.png")
    
    # show the distribution of patients living
    data$discharge_disposition_id[data$discharge_disposition_id!="Expired"] <- "Discharged"
    plot6 <- plotDist(data, "discharge_disposition_id")
    plot6 + labs(title = "Distribution of Patient Discharge Status (Expired = Fatality)",
                 y = "Number of Instances",
                 x = "Patient Discharge Status")
    ggsave("discharge distribution.png")
}

# use the apriori algorithm to mine some patterns from our data
patternMineData <- function(data)
{
    # for some reason, apriori has trouble discretizing so lets use a subset
    data <- data[, c("age", "race", "gender", "admission_type_id",
                     "discharge_disposition_id", "diabetesMed", "readmitted")]
    
    # use the apriori algorithm to find rules for patients readmitted
    rulesReadmitted <- apriori(data,
                               parameter = list(minlen = 2,
                                                supp = 0.005,
                                                conf = 0.3965),
                               appearance = list(rhs = c("readmitted=Yes"),
                                                 default = "lhs"))
    # lets sort the rules by lift
    rulesReadmitted <- sort(rulesReadmitted, by = "lift")
    
    # lets inspect the rules for readmitted patients
    inspect(rulesReadmitted[1:10,])
    
    # use the apriori algorithm to find rules for patients not readmitted
    rulesNotReadmitted <- apriori(data,
                               parameter = list(minlen = 2,
                                                supp = 0.05,
                                                conf = 0.05),
                               appearance = list(rhs = c("readmitted=No"),
                                                 default = "lhs"))
    
    # lets sort the rules by lift
    rulesNotReadmitted <- sort(rulesNotReadmitted, by = "lift")
    
    # lets inspect the rules for non readmitted patients
    # un-comment the following line in order to see these rules
    inspect(rulesNotReadmitted[1:10,])
    
    # use the apriori algorithm to find rules for patients who passed away
    rulesExpired <- apriori(data,
                                  parameter = list(minlen = 2,
                                                   supp = 0.005,
                                                   conf = 0.02),
                                  appearance = list(rhs = c("discharge_disposition_id=Expired"),
                                                    default = "lhs"))
    
    # lets sort the rules by lift
    rulesExpired <- sort(rulesExpired, by = "lift")
    
    # inspect the rules for patients who passed away
    # un-comment the following line in order to see these rules
    inspect(rulesExpired[1:10,])
}

# build various machine learning models around the dataset and
# compare them to determine the best
predictData <- function(data)
{
    # split the data into 80% train, 20% test
    data.rows <- nrow(data)
    sampleSize <- floor(0.2 * data.rows)
    index <- sample(seq_len(data.rows), size = sampleSize)
    testData <- data[index,]
    trainData <- data[-index,]
    
    # use naive bayes to predict readmission
    predictNB(trainData, testData)
    
    # use decision trees to predict readmission
    predictDT(trainData, testData)
}

# use naive bayes to predict readmission
predictNB <- function(trainData, testData)
{
    # create a model using naive bayes
    model <- naive_bayes(readmitted ~ ., data = trainData)
    
    # lets try to predict readmission using the model
    prediction <- predict(model, testData)
    
    # lets create a confusion matrix to examine the model's accuracy
    cfm <- confusionMatrix(prediction, testData$readmitted)
    
    # let's look at the confusion matrix
    print("Naive Bayes Model:")
    print(cfm)
}

# use a decision tree to predict readmission
predictDT <- function(trainData, testData)
{
    # lets train the decision tree
    model <- rpart(readmitted ~ ., data = trainData)
    
    # plot the tree
    rpart.plot(model)
    
    # lets try to predict readmission using the model
    prediction <- predict(model, testData, type = "class")
    
    # lets create a confusion matrix to examine the model's accuracy
    cfm <- confusionMatrix(prediction, testData$readmitted)
    
    # let's look at the confusion matrix
    print("Decision Tree:")
    print(cfm)
}

# this function will be used to control all required
# functions of this R script
main <- function()
{
    # check if the dataset has already been processed
    # if the data hasn't been processed, process
    # with the preprocessData() function
    if (!file.exists("10kPatientsProcessed.csv"))
    {
        preprocessData()
    }
  
    # import the data
    data <- read.csv("10kPatientsProcessed.csv")
    
    # lets visualize the distribution of our data
    # uncomment the following line in order to visualize the data
    visualizeData()
    
    # let's mine through the data and see if there are any interesting patterns
    # uncomment the following line in order to pattern mine the data
    patternMineData(data)
    
    # let's apply some machine learning algorithms to the data
    predictData(data)
}

# call the main function
main()