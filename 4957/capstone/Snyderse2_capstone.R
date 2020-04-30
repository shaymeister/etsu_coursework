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

# lets see if there is any data that contains incorrect or impossible values


# lets see how many missing values we have left
paste("The number of remaning errors before imputation", sum(is.na(data)))

# lets perform kNN computation upon the dataset
data <- kNN(data)

# show the number of empty values after kNN imputation
paste("The number of errors after imputation: ", sum(is.na(data)))
