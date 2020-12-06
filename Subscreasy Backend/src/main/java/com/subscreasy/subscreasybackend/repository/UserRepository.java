package com.subscreasy.subscreasybackend.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.subscreasy.subscreasybackend.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	 User findByUserName(String userName);
	 /*User findByEmail(String email);
	 
	 Boolean existsByUserName(String userName);
	 Boolean existsByEmail(String email);
	 
	 @Modifying
	 @Query(value = "delete from users u where u.user_name=:userName",nativeQuery = true)
	 void deleteByUserName(@Param("userName")String userName);
	 
	 @Query(value = "select * from users where admin_id =:adminId",nativeQuery = true)
	 User findUserByAdminId(@Param("adminId") int adminId);
	 
	 
	 @Query(value = "select * from users where admin_id = (select id from users where users.user_name =:userName)",
			 nativeQuery = true)
	 List<User> findAllUsersByUserName(String userName);
	 
	 @Query(value = "select u.id, u.user_name, u.name, u.last_name from users u inner join users_home uh on uh.user_id = u.id \r\n" + 
	 		"	inner join room r on uh.home_id = r.home_id inner join device d on d.room_id = r.id  \r\n" + 
	 		"	where d.id = :deviceId and u.id =:userId",nativeQuery = true)
	 User findByDeviceIdandUserId(@Param("deviceId")  UUID deviceId, @Param("userId") int userId);
	 
	 @Query(value = "select u.id, u.user_name, u.name, u.last_name from users u inner join users_home uh on uh.user_id = u.id \r\n" + 
		 		"	inner join room r on uh.home_id = r.home_id  \r\n" + 
		 		"	where r.id = :roomId and u.id =:userId",nativeQuery = true)
	 User findByRoomIDandUserID(@Param("roomId") int roomId, @Param("userId") int userId);*/
}
