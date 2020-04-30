# ----------------------------------------------------------------------------
# Author: Shay Snyder, snyderse2@etsu.edu
# Date Created: April 15, 2020
# ----------------------------------------------------------------------------
# Filename: Snyderse2.R
# Project: Ex 12 Cluster Analysis - The Wolf of Wall Street
# ----------------------------------------------------------------------------

# import data from 'PotentialClients.csv'
data <- read.csv("PotentialClients.csv")

# let's get a visual representation of our data
# before we do any major processing
plot(data)

# let's set the max number of clusters to 25 (I want to see what happends
# when we go past 15 clusters)
k.max = 25

# let's use the sum of squared distances (WSS) to determine the optimal
# number of clusters; I am following a guide posted on R-Bloggers.com
# (https://www.r-bloggers.com/finding-optimal-number-of-clusters/)
wss <- sapply(1:k.max, function(k){kmeans(data, k, nstart = 1, iter.max = 50)$tot.withinss})

# let's use an elbow plot to better visualize the information accounted
# for with different numbers of clusters; I am using the same guide as
# previously mentioned
plot(1:k.max, wss, type = "b", pch = 19, frame = FALSE,
     xlab = "Number of clusters (k)", ylab = "Sum of Squared Distance")

# from the original plot, I seen 15 distinct clusters; the wss plot
# reaffirms my theory as the data accounted for past 15 clusters
# is almost negligible; I will go with 15 as the number of clusters
clusters.km = kmeans(data, 15)

# plot the clusters with each cluster being
# represented by different colors
plot(data, col=clusters.km$cluster)