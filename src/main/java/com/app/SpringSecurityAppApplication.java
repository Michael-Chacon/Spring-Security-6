package com.app;

import com.app.persistence.entity.PermissionEntity;
import com.app.persistence.entity.RoleEmun;
import com.app.persistence.entity.RoleEntity;
import com.app.persistence.entity.UserEntity;
import com.app.persistence.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringSecurityAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAppApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository){
		return args -> {

			/*CREATE PERMISSION */
			PermissionEntity creatPermission = PermissionEntity.builder().name("CREATE").build();
			PermissionEntity readPermission = PermissionEntity.builder().name("READ").build();
			PermissionEntity updatePermission = PermissionEntity.builder().name("UPDATE").build();
			PermissionEntity deletePermission = PermissionEntity.builder().name("DELETE").build();
			PermissionEntity refactorPermisssion = PermissionEntity.builder().name("REFACTOR").build();

			/*CREATE ROLE */
			RoleEntity roleAdmin = RoleEntity.builder()
					.roleEmun(RoleEmun.ADMIN)
					.permissionList(Set.of(creatPermission, readPermission, updatePermission, deletePermission))
					.build();
			RoleEntity roleUser = RoleEntity.builder()
					.roleEmun(RoleEmun.USER)
					.permissionList(Set.of(creatPermission, readPermission))
					.build();
			RoleEntity roleGuest = RoleEntity.builder()
					.roleEmun(RoleEmun.GUEST)
					.permissionList(Set.of(readPermission))
					.build();
			RoleEntity roleDeveloper = RoleEntity.builder()
					.roleEmun(RoleEmun.DEVELOPER)
					.permissionList(Set.of(creatPermission, readPermission, updatePermission, deletePermission, refactorPermisssion))
					.build();

			/*CREATE USERS */
			UserEntity userMaritza = UserEntity.builder()
					.username("Maritza")
					.password("$2a$10$bPQBx2EoWOK2TpiP.zlD..yGE7HF5w8qx8lFdiJaWVh/Po9idLcgS")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleAdmin))
					.build();
			UserEntity userBriand = UserEntity.builder()
					.username("Briand")
					.password("$2a$10$bPQBx2EoWOK2TpiP.zlD..yGE7HF5w8qx8lFdiJaWVh/Po9idLcgS")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleUser))
					.build();
			UserEntity userDuvan = UserEntity.builder()
					.username("Duvan")
					.password("$2a$10$bPQBx2EoWOK2TpiP.zlD..yGE7HF5w8qx8lFdiJaWVh/Po9idLcgS")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleGuest))
					.build();
			UserEntity userAlexis = UserEntity.builder()
					.username("Alexis")
					.password("$2a$10$bPQBx2EoWOK2TpiP.zlD..yGE7HF5w8qx8lFdiJaWVh/Po9idLcgS")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleDeveloper))
					.build();

			userRepository.saveAll(List.of(userMaritza,userBriand, userDuvan, userAlexis));
		};
	}

}
