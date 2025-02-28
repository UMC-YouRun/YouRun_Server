package com.umc.yourun.repository;

import com.umc.yourun.domain.User;
import com.umc.yourun.domain.UserTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTagRepository extends JpaRepository<UserTag, Long> {
	public void deleteAllByUser(User user);
}
