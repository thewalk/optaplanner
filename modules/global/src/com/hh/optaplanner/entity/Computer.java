package com.hh.optaplanner.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;

@NamePattern("%s|name")
@Table(name = "OPTAPLANNER_COMPUTER")
@Entity(name = "optaplanner_Computer")
public class Computer extends StandardEntity {
    private static final long serialVersionUID = 1885598584032345663L;

    @Column(name = "NAME")
    protected String name;

    @Column(name = "CPU_POWER")
    protected Integer cpuPower;

    @Column(name ="MEMORY")
    protected Integer memory;

    @Column(name = "NETWORK_BANDWIDTH")
    protected Integer networkBandwidth;

    @Column(name = "COST")
    protected Integer cost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLOUD_BALANCE_ID")
    protected CloudBalance cloudBalance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCpuPower() {
        return cpuPower;
    }

    public void setCpuPower(Integer cpuPower) {
        this.cpuPower = cpuPower;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public Integer getNetworkBandwidth() {
        return networkBandwidth;
    }

    public void setNetworkBandwidth(Integer networkBandwidth) {
        this.networkBandwidth = networkBandwidth;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public CloudBalance getCloudBalance() {
        return cloudBalance;
    }

    public void setCloudBalance(CloudBalance cloudBalance) {
        this.cloudBalance = cloudBalance;
    }
}