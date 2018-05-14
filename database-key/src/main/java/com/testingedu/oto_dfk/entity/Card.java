package com.testingedu.oto_dfk.entity;


import javax.persistence.*;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GenericGenerator(name = "pid",strategy = "assigned")
    @Column(length = 18)
    private Integer id;
    private Integer cid;
    @OneToOne(mappedBy = "cid")//被控方card添加主控方,"cid"是学生引用的外键
    Student sid;

    public void setSid(Student sid) {
        this.sid = sid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Card(Integer cid) {
        this.cid = cid;
    }

    public Card() {
    }
}
