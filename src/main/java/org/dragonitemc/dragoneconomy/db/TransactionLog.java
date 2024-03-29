package org.dragonitemc.dragoneconomy.db;

import javax.annotation.Nullable;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "DragonEncomy_TransactionLog")
public class TransactionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String operator;

    @Column
    private LocalDateTime time;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.REMOVE})
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private EconomyUser user;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.REMOVE})
    @JoinColumn(name = "target_id", referencedColumnName = "id", nullable = false)
    private EconomyUser target;

    @Column
    private double amount;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private Action action;


    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Nullable
    public EconomyUser getUser() {
        return user;
    }

    public void setUser(EconomyUser user) {
        this.user = user;
    }

    public EconomyUser getTarget() {
        return target;
    }

    public void setTarget(EconomyUser target) {
        this.target = target;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public enum Action {
        DEPOSIT, WITHDRAW, TRANSFER, SET
    }

}