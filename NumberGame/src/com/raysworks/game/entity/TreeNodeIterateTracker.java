package com.raysworks.game.entity;

public class TreeNodeIterateTracker {
	private int nodesIterateCount;
	public int getNodesIterateCount() {
		return nodesIterateCount;
	}
	public void setNodesIterateCount(int nodesIterateCount) {
		this.nodesIterateCount = nodesIterateCount;
	}
	public void addNodesIterateCount() {
		this.nodesIterateCount++;
	}
	public String toString() {
		return "TreeNodeIterateTracker [nodesIterateCount=" + nodesIterateCount + "]";
	}
}
