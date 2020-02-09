# ------------------------------------------------------------------
# File Name: snyderse2-exercise3.R
# Project Name: Data Analytics Exercise 3
# Author: Shay Snyder snyderse2@etsu.edu
# Date Created: February 8, 2019
# -----------------------------------------------------------------------------

# import library that contains methodology to calculate p-values
library(Hmisc)


# import data from income_data.csv
income_data = read.csv(file = 'income_data.csv') # import data from income_data.csv

# show the summary of income_data
print(summary(income_data))

# show histogram of prestige
hist(income_data[,c("prestige")])

# plot income and education
plot(income_data[,c("education", "income")])

# calc standard deviation and variance
income_var = var(income_data[,c("income")])
income_sd = sd(income_data[,c("income")])

# show the var and sd of income
paste("Income Variance: ", income_var)
paste("Income Deviation: ", income_sd)


# create a matrix that contains income and education
income_edu = as.matrix(income_data[,c("income","education")])

# display their correlation
print(rcorr(income_edu, type="pearson"))