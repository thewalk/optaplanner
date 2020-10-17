
package com.hh.optaplanner.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import javax.persistence.*;

@NamePattern("%s|name")
@Table(name = "OPTAPLANNER_PROCESS")
@Entity(name = "optaplanner_Process")
@PlanningEntity
public class Process extends StandardEntity {
    private static final long serialVersionUID = 3203834426142103078L;

    @Column(name = "NAME")
    protected String name;

    @Column(name = "REQUIRED_CPU_POWER")
    protected Integer requiredCpuPower;

    @Column(name = "REQUIRED_MEMORY")
    protected Integer requiredMemory;

    @Column(name = "REQUIRED_NETWORK_BANDWIDTH")
    protected Integer requiredNetworkBandwidth;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPUTER_ID")
    protected Computer computer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLOUD_BALANCE_ID")
    protected CloudBalance cloudBalance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRequiredCpuPower() {
        return requiredCpuPower;
    }

    public void setRequiredCpuPower(Integer requiredCpuPower) {
        this.requiredCpuPower = requiredCpuPower;
    }

    public Integer getRequiredMemory() {
        return requiredMemory;
    }

    public void setRequiredMemory(Integer requiredMemory) {
        this.requiredMemory = requiredMemory;
    }

    public Integer getRequiredNetworkBandwidth() {
        return requiredNetworkBandwidth;
    }

    public void setRequiredNetworkBandwidth(Integer requiredNetworkBandwidth) {
        this.requiredNetworkBandwidth = requiredNetworkBandwidth;
    }

    @PlanningVariable(valueRangeProviderRefs = {"computerRange"})
    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public CloudBalance getCloudBalance() {
        return cloudBalance;
    }

    public void setCloudBalance(CloudBalance cloudBalance) {
        this.cloudBalance = cloudBalance;
    }
}