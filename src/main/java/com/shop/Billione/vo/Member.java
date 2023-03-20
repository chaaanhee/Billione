package com.shop.Billione.vo;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@DynamicInsert
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerNo;
    @Column(length = 50, nullable = false, unique = true)
    private String email;
    @Column(length = 30, nullable = false)
    private String password;
    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 30, nullable = false)
    private String phone;
    @ColumnDefault("Y")
    @Column(length = 1, nullable = false)
    private String email_check;
    @ColumnDefault("U")
    @Column(length = 1, nullable = false)
    private String identifier;
    @ColumnDefault("B")
    @Column(length = 1, nullable = false)
    private String rank;
    @CreationTimestamp
    @Column(length = 1, nullable = false)
    private Timestamp enrollDate;
    @ColumnDefault("N")
    @Column(length = 1, nullable = false)
    private String withdraw;
}
