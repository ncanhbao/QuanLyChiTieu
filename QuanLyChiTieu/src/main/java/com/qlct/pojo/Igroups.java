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
@Table(name = "igroups")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Igroups.findAll", query = "SELECT i FROM Igroups i"),
    @NamedQuery(name = "Igroups.findById", query = "SELECT i FROM Igroups i WHERE i.id = :id"),
    @NamedQuery(name = "Igroups.findByName", query = "SELECT i FROM Igroups i WHERE i.name = :name")})
public class Igroups implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users ownerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId")
    private Set<GroupMembers> groupMembersSet;
    @OneToMany(mappedBy = "groupId")
    private Set<Users> usersSet;

    public Igroups() {
    }

    public Igroups(Integer id) {
        this.id = id;
    }

    public Igroups(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Users getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Users ownerId) {
        this.ownerId = ownerId;
    }

    @XmlTransient
    public Set<GroupMembers> getGroupMembersSet() {
        return groupMembersSet;
    }

    public void setGroupMembersSet(Set<GroupMembers> groupMembersSet) {
        this.groupMembersSet = groupMembersSet;
    }

    @XmlTransient
    public Set<Users> getUsersSet() {
        return usersSet;
    }

    public void setUsersSet(Set<Users> usersSet) {
        this.usersSet = usersSet;
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
        if (!(object instanceof Igroups)) {
            return false;
        }
        Igroups other = (Igroups) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qlct.pojo.Igroups[ id=" + id + " ]";
    }
    
}
