package com.migu.schedule.info;

import java.util.Objects;

/**
 * 任务状态信息类，请勿修改。
 *
 * @author
 */
public class TaskInfo {
    private int taskId;
    private int nodeId;
    private int consumption;

    public TaskInfo(int taskId, int consumption) {
        this.taskId = taskId;
        this.consumption = consumption;
    }

    public int getNodeId() {
        return nodeId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskInfo taskInfo = (TaskInfo) o;
        return taskId == taskInfo.taskId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId);
    }

    @Override
    public String toString() {
        return "TaskInfo [taskId=" + taskId + ", nodeId=" + nodeId + "]";
    }
}
