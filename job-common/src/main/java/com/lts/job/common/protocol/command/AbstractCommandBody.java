package com.lts.job.common.protocol.command;

import com.lts.job.common.support.Application;
import com.lts.job.remoting.CommandBody;
import com.lts.job.remoting.annotation.NotNull;
import com.lts.job.remoting.annotation.Nullable;
import com.lts.job.remoting.exception.RemotingCommandFieldCheckException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Robert HG (254963746@qq.com) on 7/24/14.
 * 抽象的header 传输信息
 */
public class AbstractCommandBody implements CommandBody {

    /**
     * 节点组 当前节点的 group(统一类型, 具有相同功能的节点group相同)
     */
    @NotNull
    private String nodeGroup;

    /**
     * NodeType 的字符串表示, 节点类型
     */
    @NotNull
    private String nodeType;

    /**
     * 当前节点的唯一标识
     */
    @NotNull
    private String identity;

    // 可用的线程数 (对 TaskTracker才有作用)
    private Integer availableThreads;

    private Long timestamp = System.currentTimeMillis();

    // 额外的参数
    @Nullable
    private Map<String, Object> extParams;

    public AbstractCommandBody() {
        this.nodeGroup = Application.Config.getNodeGroup();
        this.nodeType = Application.Config.getNodeType().name();
        this.identity = Application.Config.getIdentity();
        this.availableThreads = Application.getAttribute(Application.KEY_AVAILABLE_THREADS);
    }

    public Integer getAvailableThreads() {
        return availableThreads;
    }

    public void setAvailableThreads(Integer availableThreads) {
        this.availableThreads = availableThreads;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getNodeGroup() {
        return nodeGroup;
    }

    public void setNodeGroup(String nodeGroup) {
        this.nodeGroup = nodeGroup;
    }

    public Map<String, Object> getExtParams() {
        return extParams;
    }

    public void setExtParams(Map<String, Object> extParams) {
        this.extParams = extParams;
    }

    public void putExtParam(String key, Object obj) {
        if (this.extParams == null) {
            this.extParams = new HashMap<String, Object>();
        }
        this.extParams.put(key, obj);
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Override
    public void checkFields() throws RemotingCommandFieldCheckException {

    }
}
