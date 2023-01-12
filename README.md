# Tree

Tree Traversel - printing every key of the the tree exactly once

## BROADLY CLASSIFIED INTO TWO CATEGORIES
BFS - Breadth First Search/Level order Traversel - You visit the root first then you vistit the next level from left to right 
DFS - Depth First Search - we got to one side, we finish it completely, then we go to the other side

	       10
	     /    \
	    20    30
	   /  \	 
	  40  50

BFS - 10, 20, 30, 40, 50
DFS - 10, 20, 40, 50, 30

## DFS can be done in three ways:
	1) Preorder	(root left right)
	2) Inorder	(left root right)
	3) Postorder	(left right root)

	In all these three traversel we visit left subtree before the right subtree


## Inorder traversel
	we visit the left subtree first (whole), then we visit the root, then we visit the right subtree (whole)

Exercise:
	       10
	     /    \
	    20    30
	  /    \     \ 
	 40    50    60
	     /    \
	    70    80

	Inorder:   40,20,70,50,80,10,30,60
	Preorder:  10,20,40,50,70,80,30,60
	Postorder: 40,70,80,50,20,60,30,10

# PLEASE REMEMBER one thing when you recursively call for a subtree, if this subtree has single node you print it otherwise you follow the same process recursively

