import com.comp.trainingapp.UserLogin
import com.comp.trainingapp.UserLoginRole
import com.comp.trainingapp.UserLoginUserLoginRole
import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils

class BootStrap {

    def init = { servletContext ->
		if(UserLoginRole.count == 0) {
			createSuperAdminUser()
			createAdminUser()
			createUser()
		}
    }
    def destroy = {
    }
	
	def createSuperAdminUser() {
		def superAdmin = UserLogin.findByUsername("superadmin")
		def role = UserLoginRole.findByAuthority("ROLE_SUPER_ADMIN")
		if (!superAdmin) {
			def conf = SpringSecurityUtils.securityConfig
			String password = "admin123"
			def uuid = java.util.UUID.randomUUID().toString()
			superAdmin = new UserLogin(username: 'superadmin',
			password: password,
			enabled: true,
			accountExpired:false,
			accountLocked:false,
			passwordExpired:false)
			//		admin.addToAuthorities(role)
			superAdmin.save(flush:true , failOnError:true)
			if (!role) {
				role = new UserLoginRole()
				role.authority="ROLE_SUPER_ADMIN"
				role.save(flush:true , failOnError:true)
			}

			new UserLoginUserLoginRole(userLogin:superAdmin ,userLoginRole:role).save(flush:true , failOnError:true)
		}
	}
	
	
	def createAdminUser() {
		def superAdmin = UserLogin.findByUsername("admin")
		def role = UserLoginRole.findByAuthority("ROLE_ADMIN")
		if (!superAdmin) {
			def conf = SpringSecurityUtils.securityConfig
			String password = "admin123"
			def uuid = java.util.UUID.randomUUID().toString()
			superAdmin = new UserLogin(username: 'admin',
			password: password,
			enabled: true,
			accountExpired:false,
			accountLocked:false,
			passwordExpired:false)
			//		admin.addToAuthorities(role)
			superAdmin.save(flush:true , failOnError:true)
			if (!role) {
				role = new UserLoginRole()
				role.authority="ROLE_ADMIN"
				role.save(flush:true , failOnError:true)
			}

			new UserLoginUserLoginRole(userLogin:superAdmin ,userLoginRole:role).save(flush:true , failOnError:true)
		}
	}
	
	
	def createUser() {
		def superAdmin = UserLogin.findByUsername("user")
		def role = UserLoginRole.findByAuthority("ROLE_USER")
		if (!superAdmin) {
			def conf = SpringSecurityUtils.securityConfig
			String password = "admin123"
			def uuid = java.util.UUID.randomUUID().toString()
			superAdmin = new UserLogin(username: 'user',
			password: password,
			enabled: true,
			accountExpired:false,
			accountLocked:false,
			passwordExpired:false)
			//		admin.addToAuthorities(role)
			superAdmin.save(flush:true , failOnError:true)
			if (!role) {
				role = new UserLoginRole()
				role.authority="ROLE_USER"
				role.save(flush:true , failOnError:true)
			}

			new UserLoginUserLoginRole(userLogin:superAdmin ,userLoginRole:role).save(flush:true , failOnError:true)
		}
	}
}
