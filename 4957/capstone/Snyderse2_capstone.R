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

preprocessData <- function()
{
  # import the 10k patients dataset
  data <- read.csv("10kPatients.csv", header = TRUE, na.strings = c("", "?", "Not Available", "Not Mapped"))
  
  # show the number of missing values before removing mostly empty columns 
  paste("The number of errors before removing mostly emply columns: ", sum(is.na(data)))
  
  # lets see what percentage of the whole dataset is empty
  paste("Percenage of whole dataset that is empty: ", mean(is.na(data)))
  
  # lets see which columns are missing over half of their data
  paste("Percentage of missing values in each column: ", colMeans(is.na(data)))
  
  # lets remove those columns that are missing over half of their data
  data <- select(data, -c("weight", "payer_code"))

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
visualizeData <- function(data)
{
    # show the distribution of patients readmitted vs not readmitted
    plot1 <- showDist(data, "readmitted")
    plot1 + labs(title = "Distribution of Patient Readmissions",
                 y = "Number of Instances",
                 x = "Was the Patient Readmitted?")
    ggsave("readmission distribution.png")
  
    # show the distribution of patients on diabetic medication
    plot2 <- showDist(data, "diabetesMed")
    plot2 + labs(title = "Distribution of Patients on Diabetes Medicine",
                 y = "Number of Instances",
                 x = "Is the Patient on Diabetes Medicine?")
    ggsave("diabetic medication distribution.png")
    
    # show the distribution of patient race
    plot3 <- showDist(data, "race")
    plot3 + labs(title = "Distribution of Race",
                 y = "Number of Instances",
                 x = "Race")
    ggsave("race distribution.png")
    
    # show the distribution of patient age
    plot4 <- showDist(data, "age")
    plot4 + labs(title = "Distribution of Age",
                 y = "Number of Instances",
                 x = "Age")
    ggsave("age distribution.png")
    
    # show the distribution of patient gender
    plot5 <- showDist(data, "gender")
    plot5 + labs(title = "Distribution of Gender",
                 y = "Number of Instances",
                 x = "Gender")
    ggsave("gender distribution.png")
    
    # show the distribution of patients living
    data$discharge_disposition_id[data$discharge_disposition_id!="Expired"] <- "Discharged"
    plot6 <- showDist(data, "discharge_disposition_id")
    plot6 + labs(title = "Distribution of Patient Discharge Status (Expired = Fatality)",
                 y = "Number of Instances",
                 x = "Patient Discharge Status")
    ggsave("discharge distribution.png")
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
    
    dim(data)
    # lets visualize the distribution of our data
    visualizeData(data)
}

# call the main function
main()

