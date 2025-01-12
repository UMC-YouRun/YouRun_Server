package com.umc.yourun.domain;

import java.util.ArrayList;
import java.util.List;

import com.umc.yourun.domain.mapping.UserCrew;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Crew {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false,unique = true)//TODO: 유니크 여부 물어보기
	private String name;
	@Column
	private String cheerMessage;
	@Column
	private Long adminId;
	@Column
	private Integer winningCount=0;

	@OneToMany(mappedBy = "crew",cascade = CascadeType.ALL)
	private List<UserCrew> userCrews=new ArrayList<>();

	public void addUserCrew(UserCrew userCrew){
		userCrews.add(userCrew);
		userCrew.setCrew(this);
	}
}
