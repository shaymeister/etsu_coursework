# -------------------------------------------------------------------
# Author: Shay Snyder, snyderse2@etsu.edu
# Date Created: April 28, 2020
# -------------------------------------------------------------------
# File name: Snyderse2_ex13.R
# Project: Exercise 13: Outlier Detection
# -------------------------------------------------------------------

# packages
library(car)
library(rgl)
library(mvoutlier)
library(cluster)
library(DMwR)

# import data from 'carsDataset' & 'bankloan'
carData <- read.csv("carsDataset.csv")
loanData <- read.csv("bankloan.csv")

# Problem 1 ---------------------------------------------------------

# subset columns to cars.features, mpg, qsec, and hp
carData <- mtcars[, c("mpg", "qsec", "hp")]

# lets look at our data in 3D
scatter3d(x = carData$mpg,
          y = carData$qsec,
          z = carData$hp,
          labels = rownames(carData))

# well our 3D scatterplot was pretty but it provided little information
# for our specific challenge because (I now realize) that it is quite
# difficult to visually determine outliers from 3D visualizations
# lets try mvoutlier
uni.plot(carData)

# END: Problem 1 ----------------------------------------------------

# Problem 2 ---------------------------------------------------------

# lets make a boxplot of the desired columns
boxplot(loanData[,c(1,5,6,7,11,13,14)])

# let's build our own daisy function to find our outliets
# we telling the daisy function to use the Gower metric and we are
# specifying the different types of data in each column
ourFunction <- daisy(loanData[,-19], stand = TRUE, metric = c("gower"),
                         type = list(nominal = c(2,4,12),
                                     symm = c(3),
                                     asymm = c(10,15,16)))

# lets determine the hierachy of all our outliers
outlierHierarchy <- outliers.ranking(ourFunction, method = "sizeDiff", meth = "ward.D")

# let's see the top 15 outliers
print(outlierHierarchy$rank.outliers, max = 15)

# END: Problem 2 ----------------------------------------------------