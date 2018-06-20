package com.migu.schedule.info;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class NodeInfo {

    private int nodeId;
    private Set<TaskInfo> taskList = new HashSet<>();

    public NodeInfo(int nodeId) {
        this.nodeId = nodeId;
    }

    public int getNodeId() {
        return nodeId;
    }

    public Set<TaskInfo> getTaskList() {
        return taskList;
    }

    public void addTask(TaskInfo info) {
        taskList.add(info);
    }

    public void deleteTask(TaskInfo info) {
        taskList.remove(info);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeInfo nodeInfo = (NodeInfo) o;
        return nodeId == nodeInfo.nodeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodeId);
    }
}
