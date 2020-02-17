# ------------------------------------------------------------------------------
# File Name: snyderse2-ex4.R
# Project Name: Data Analytics Exercise 4
# Author: Shay Snyder snyderse2@etsu.edu
# Date Created: February 14, 2019
# ------------------------------------------------------------------------------

# Required Packages
library(deducorrect) # install.packages("deducorrect")
library(errorlocate) # install.packages("errorlocate")
library(VIM) # install.packages("VIM")

# Import data from "income_dirty_data.csv"
data <- read.csv('Income Dirty Data.csv', row.names = 1)

# Calculate and print the nuumber of missings
# values along with the percentage of them
paste("Sum of missing values: ", sum(is.na(data)))
paste("Percentage of missing values: ", mean(is.na(data)))

# define the correction rules
rules <- validator( age >= 18,
                    tax == income * .15,
                    income > 0)

# display a summary of the dataset's errors
print("What percentage of the data has no errors?")
summary(locate_errors(data, rules))

# display a summary of the dataset before imputation
print("Data Before Imputation")
summary(data)

# correct the gender entries who don't equal "Male" or "Female"
# if tax is not defined but income is, calculate tax
# if income in not defined but tax is, calculate income
# if income or tax is less than zero, set to NA
# if age is less than 18, set to NA
cr <- correctionRules( expression(
    if(!is.na(gender) & (gender == "Man" | gender == "Men")) gender <- "Male",
    if(!is.na(gender) & (gender == "Woman" | gender == "Women")) gender <- "Female",
    if(!is.na(tax) & tax >= 0 & (income < 0 | is.na(income))) income <- (tax / 0.15),
    if(!is.na(income) & is.na(tax)) tax <- (income * 0.15),
    if(!is.na(income) & income <= 0) income <-  NA,
    if(!is.na(tax) & tax < 0) tax <- NA,
    if(age < 18) age <- NA))

# apply all corrections
clean_data <- correctWithRules(cr, data)

# apply the corrected data set to data
data = kNN(clean_data$corrected)

# display a summmary of the data after kNN
print("Data After Imputation")
summary(data)