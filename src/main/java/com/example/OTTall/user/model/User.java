package com.example.OTTall.user.model;

import com.example.OTTall.config.Auditable;
import com.example.OTTall.story.model.Story;
import com.example.OTTall.survey.model.DessertSurvey;
import com.example.OTTall.survey.model.ExerciseSurvey;
import com.example.OTTall.survey.model.FoodSurvey;
import com.example.OTTall.survey.model.MediaSurvey;
import com.example.OTTall.user.dto.PostSignInReq;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//외래키 preference랑 설정
@Entity
@Table(name="User")
@Setter
@Getter
@AllArgsConstructor
public class User extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx;

    private String email;

    private String nickName;

    private String pwd;

    private String profileImg = null;

    @OneToOne(mappedBy = "user")
    private DessertSurvey dessertSurvey;

    @OneToOne(mappedBy = "user")
    private ExerciseSurvey exerciseSurvey;

    @OneToOne(mappedBy = "user")
    private FoodSurvey foodSurvey;

    @OneToOne(mappedBy = "user")
    private MediaSurvey mediaSurvey;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Story> stories = new ArrayList<>();

    public User(){}
    public User(PostSignInReq postSignInReq, String password){
        this.email = postSignInReq.getEmail();
        this.pwd = password;
        this.nickName = postSignInReq.getNickName();
    }

}
