    $(document).ready(function()
    {
      
      $("#signUp").validate(
      {
        rules:{
        	companyName:"required",
        	term:"required",
        	
        	companyUserName:"required",
        	term:"required",
        	
        	email:{	
                required:true,
                email: true

                },
            password:{
                    required:true,
                  },
            conPassword:{
                    required:true,
                    equalTo: "#password"
                      },
          },
        errorClass: "help-inline-note" 
      });
    });