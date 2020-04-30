# ------------------------------------------------------------------------------
# Author: Shay Snyder, snyderse2@etsu.edu
# File Name: snyderse2_ex10.R
# Project Name: Exercise 10: Pattern Mining w/ Apriori
# Date Created: March 28th, 2020
# Date Last Modified: March 30th, 2020
# ------------------------------------------------------------------------------

# Load the library containing the Apriori algorithm
library(arules)

# Load the data from 'TitanicData.csv'
data <- read.csv('TitanicData.csv')

# Mine association rules from 'TitanicData.csv'
rules <- apriori(data)

# Lets take a closer look at the rules
inspect(rules)

# Apply our thresholds to a new set of rules
# min rule length = 2
# support = 0.005
# confidence = 0.8
rules2 <- apriori(data, parameter = list(minlen = 2, support = 0.005, conf = 0.8), appearance = list(rhs = c("Survived=No", "Survived=Yes"), default = "lhs"))

# Lets take a closer look at the second set of rules
inspect(rules2)

# sort 'rules2' by lift
rules2_sorted <- sort(rules2, by = "lift")

# Let's take a closer look at the sorted rules
inspect(rules2_sorted)