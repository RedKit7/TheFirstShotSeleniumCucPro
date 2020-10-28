Feature: 

	#User Story : 
	#
	#As a user, I should be able to interact with
	#employees on the posts that I have access to.
	#
	#AC:
	#
	#User should be able to make a comment, like, or unfollow on other employees' posts.
	#
	# 

	@EUG3-139

		Scenario: User should be able to make a comment, like, or unfollow on other employees' posts.
		
		  Given User should be able to access url and be able see home page
		  When User should be able to make a comment on other employees' posts.
		  And User should be able like on other employees' posts.
		  And User should be able unfollow on other employees' posts.
		  Then  Users should see their comment , like and other employess posts"