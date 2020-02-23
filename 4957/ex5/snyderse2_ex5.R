# ---------------------------------------------------------------------------
# File name: snyderse2_ex5.R
# Project name: Data Analytics Exercise 5
# ---------------------------------------------------------------------------
# Creator's name and email: Shay Snyder, snyderse2@etsu.edu
# Course:  CSCI 4957
# Creation Date: Feb 18, 2020
# ---------------------------------------------------------------------------

# read the data from "Album Sales 3.csv"
data = read.csv("Album Sales 3.csv")

# plot the data to visualize the relationships
# between various attributes
attach(data)
plot(sales, adverts)
plot(sales, airplay)
plot(sales, attract)

# create a simple regression model from data where
# sales is a function of adverts
simple_model = lm(sales ~ adverts, data)

# display a summary of the simple model
summary(simple_model)

# create a complex regression moden from data where
# sales is a function of adverts, airplay, and attract
complex_model = lm(sales ~ adverts+airplay+attract, data)

# display a summary of the complex model
summary(complex_model)

# compare the two models
anova(simple_model, complex_model)
