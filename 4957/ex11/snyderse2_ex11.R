# ----------------------------------------------------------------------------
# Author: Shay Snyder, snyderse2@etsu.edu
# Date Created: April 4, 2020
# Data Last Modified: April 4, 2020
# ----------------------------------------------------------------------------
# File Name: snyderse2_ex11.R
# Project: Exercise 11: Classification
# Goal: Use the 'adultsData‘ dataset and apply decision tree and naïve
#   Bayesian methods to predict whether a person’s income will exceed $50K/yr.
# ----------------------------------------------------------------------------

library(caret) # for stratified split
library(e1071) # to calculate confusion matrix (very weird name lol)
library(naivebayes) # for naive bayes model
library(rpart) # to build decision tree
library(rpart.plot) # to plot decision tree

# import income data from 'adultsData.csv'
data <- read.csv("adultsData.csv")

# use the createDataPartition() function in the 'caret' package to 
# create a stratified split of training and test data
train.index <- createDataPartition(data$class, p = .8, list = FALSE)

# use the output of the createDataPartion() function to split the data
trainData = data[train.index,]
testData = data[-train.index,]

# lets the dimensions of our initial, test, and train data
dim(data)
dim(trainData)
dim(testData)

# lets build the decision tree
tree <- rpart(class ~ ., data = trainData)

# plot our tree
rpart.plot(tree)

# test our testData against the decision tree
tree.predicted <- predict(tree, testData, type = "class")

# lets see how our decision tree compares against our test data
confusionMatrix(tree.predicted, testData$class)

# lets try the bayes model
bayes <- naive_bayes(class ~ ., data = trainData)

# lets see how our bayes model does against our test data
bayes.predicted <- predict(bayes, testData)

# lets calculate the confusion matrix
confusionMatrix(bayes.predicted, testData$class)