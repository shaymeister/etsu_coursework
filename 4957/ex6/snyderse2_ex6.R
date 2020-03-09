# ------------------------------------------------------------------------------
# Author: Shay Snyder snyderse2@etsu.edu
# Created on: March 3, 2020
# File name: snyderse2_ex6.R
# Project: Exercise 6
# ------------------------------------------------------------------------------

# load the gmodels library
library(gmodels)

# import the happy data from 'Americandata.csv'
data <- read.csv("Americandata.csv")

# remove the categorical attribute for yes/no in the first column
data <- data[,2:9]

# covert the data to a matrix so the CrossTable function can be used
dataAsMatrix <- data.matrix(data)

# do a chi-square test across the entire data
CrossTable(dataAsMatrix, expected=TRUE, chisq = TRUE, sresid = TRUE, format="SPSS")