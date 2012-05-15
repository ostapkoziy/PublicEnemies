	
$(function()
		{
			var login = $("#email");
			var pass = $("#password");
			var button = $("#button");
			//button.fadeOut(1000);
			var isLoginTrue = false;
			var isPassTrue = false;
			// Matches____ e@eee.com | eee@e-e.com | eee@ee.eee.museum
			// Non-Matches .@eee.com | eee@e-.com | eee@ee.eee.eeeeeeeeee
			var regLogin = /^([0-9a-zA-Z]([-.\w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-\w]*[0-9a-zA-Z]\.)+[a-zA-Z]{2,9})$/;
			// 6-10 symbols pass
			var regPass = /^([A-z0-9]{6,10})$/;
			login.keyup(function()
			{
				if (login.val().search(regLogin) == -1)
				{
					login.removeClass("correct").addClass("error");
					isLoginTrue = false;
					button.fadeOut(1000);
					$("div#email_error").empty().append("Invalid email adress");
				}
				else
				{
					login.removeClass("error").addClass("correct");
					isLoginTrue = true;
					if (isPassTrue){
						button.fadeIn(1000);
						
					}	
					$("div#email_error").empty();	
				}

			});
			pass.keyup(function()
			{
				if (pass.val().search(regPass) == -1)
				{
					pass.removeClass("correct").addClass("error");
					isPassTrue = false;
					button.fadeOut(1000);
					$("div#password_error").empty().append("Password must be from 6 to 10 symbols long");
					
				}
				else
				{
					pass.removeClass("error").addClass("correct");
					isPassTrue = true;
					if (isLoginTrue){
						button.fadeIn(1000);
						
					}
					$("div#password_error").empty();
				}

			});

		});
