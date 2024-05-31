/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlct.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ncanh
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"),
    @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findByRole", query = "SELECT u FROM Users u WHERE u.role = :role"),
    @NamedQuery(name = "Users.findByAvatar", query = "SELECT u FROM Users u WHERE u.avatar = :avatar"),
    @NamedQuery(name = "Users.findByIsActive", query = "SELECT u FROM Users u WHERE u.isActive = :isActive")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "role")
    private String role;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "is_active")
    private Boolean isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerId")
    private Set<Igroups> igroupsSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Set<GroupMembers> groupMembersSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Set<Availability> availabilitySet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Set<Transactions> transactionsSet;
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @ManyToOne
    private Igroups groupId;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, String username, String password, String role, String avatar) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.avatar = avatar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public Set<Igroups> getIgroupsSet() {
        return igroupsSet;
    }

    public void setIgroupsSet(Set<Igroups> igroupsSet) {
        this.igroupsSet = igroupsSet;
    }

    @XmlTransient
    public Set<GroupMembers> getGroupMembersSet() {
        return groupMembersSet;
    }

    public void setGroupMembersSet(Set<GroupMembers> groupMembersSet) {
        this.groupMembersSet = groupMembersSet;
    }

    @XmlTransient
    public Set<Availability> getAvailabilitySet() {
        return availabilitySet;
    }

    public void setAvailabilitySet(Set<Availability> availabilitySet) {
        this.availabilitySet = availabilitySet;
    }

    @XmlTransient
    public Set<Transactions> getTransactionsSet() {
        return transactionsSet;
    }

    public void setTransactionsSet(Set<Transactions> transactionsSet) {
        this.transactionsSet = transactionsSet;
    }

    public Igroups getGroupId() {
        return groupId;
    }

    public void setGroupId(Igroups groupId) {
        this.groupId = groupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qlct.pojo.Users[ id=" + id + " ]";
    }
    
}
