package com.example.restfulwebservice.domain;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"joinDate"})
//@JsonFilter("UserInfo")
@ApiModel(description = "사용자 상세 정보를 위한 도메인 객체")
@Entity
public class User {

    @Id @GeneratedValue
    private Integer id;

    @Size(min = 2, message = "2글자 이상 입력")
    @ApiModelProperty(notes = "사용자 이름을 입력")
    private String name;

    @Past
    @ApiModelProperty(notes = "사용자 등록일을 입력")
    private LocalDateTime joinDate;

    @ApiModelProperty(notes = "사용자 비번을 입력")
    private String password;

    @ApiModelProperty(notes = "사용자 주민번호를 입력")
    private String ssn;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    public User(int id, String name, LocalDateTime joinDate, String password, String ssn) {
        this.id = id;
        this.name = name;
        this.joinDate = joinDate;
        this.password = password;
        this.ssn = ssn;
    }
}
