package com.migu.schedule;


import com.migu.schedule.constants.ReturnCodeKeys;
import com.migu.schedule.info.NodeInfo;
import com.migu.schedule.info.TaskInfo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*
 * 类名和方法不能修改
 */
public class Schedule {
    private Set<NodeInfo> nodeList;
    private Set<TaskInfo> hangList;

    public int init() {
        nodeList = new HashSet<NodeInfo>();
        hangList = new HashSet<TaskInfo>();
        return ReturnCodeKeys.E001;
    }

    public int registerNode(int nodeId) {
        if (nodeId <= 0) return ReturnCodeKeys.E004;
        NodeInfo node = new NodeInfo(nodeId);
        if (nodeList.contains(node))
            return ReturnCodeKeys.E005;
        nodeList.add(node);
        return ReturnCodeKeys.E003;
    }

    public int unregisterNode(int nodeId) {
        if (nodeId <= 0) return ReturnCodeKeys.E004;
        boolean exist = false;
        Iterator<NodeInfo> iterator = nodeList.iterator();
        while (iterator.hasNext()) {
            NodeInfo node = iterator.next();
            if (node.getNodeId() == nodeId) {
                exist = true;
                iterator.remove();
                break;
            }
        }
        if (!exist) {
            return ReturnCodeKeys.E007;
        }
        return ReturnCodeKeys.E006;
    }

    public int addTask(int taskId, int consumption) {
        if (taskId <= 0) return ReturnCodeKeys.E009;
        TaskInfo taskInfo = new TaskInfo(taskId, consumption);
        if (hangList.contains(taskInfo))
            return ReturnCodeKeys.E010;
        hangList.add(taskInfo);
        return ReturnCodeKeys.E008;
    }

    public int deleteTask(int taskId) {
        if (taskId <= 0) return ReturnCodeKeys.E009;
        boolean exist = false;
        for (NodeInfo node : nodeList) {
            exist = this.removeFromList(node.getTaskList().iterator(), taskId);
            if (exist) break;
        }
        if (!exist) {
            if (!this.removeFromList(hangList.iterator(), taskId)) {
                return ReturnCodeKeys.E012;
            }
        }
        return ReturnCodeKeys.E011;
    }

    private boolean removeFromList(Iterator<TaskInfo> iterator, int taskId) {
        while (iterator.hasNext()) {
            TaskInfo taskInfo = iterator.next();
            if (taskInfo.getTaskId() == taskId) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public int scheduleTask(int threshold) {
        // TODO 方法未实现
        return ReturnCodeKeys.E000;
    }

    private void initAssign(int threshold) {

    }

    public int queryTaskStatus(List<TaskInfo> tasks) {
        if (tasks == null) return ReturnCodeKeys.E016;
        if (tasks.size() != 0)
            tasks.clear();
        for (NodeInfo node : nodeList) {
            tasks.addAll(node.getTaskList());
        }
        for (TaskInfo info : hangList) {
            info.setNodeId(-1);
            tasks.add(info);
        }
        return ReturnCodeKeys.E015;
    }

}
