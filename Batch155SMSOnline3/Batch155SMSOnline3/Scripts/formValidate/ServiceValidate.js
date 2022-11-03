$(document).ready(function () {
    $("#frmCreateService").validate({
        rules: {
            ServiceName: {
                required: true,
                minlength: 5,
                maxlength: 25
            },
            Price: {
                number: true,
                min: 10000
            }
        },
		messages: {
			
            ServiceName: {
                required: "Enter a service name",
				minlength: jQuery.validator.format("Enter at least {0} characters"),
				maxlength: jQuery.validator.format("Enter at maximum {0} characters")
			},			
            Price: {
				number: "Please enter numbers only.",
                min: "Please enter a a value greater than or equal to 10.000",
				
			}
		}
    });
    $("#frmEditService").validate({
        rules: {
            ServiceName: {
                required: true,
                minlength: 5,
                maxlength: 25
            },
            Price: {
                number: true,
                min: 10000
            }
        },
        messages: {

            ServiceName: {
                required: "Enter a service name",
                minlength: jQuery.validator.format("Enter at least {0} characters"),
                maxlength: jQuery.validator.format("Enter at maximum {0} characters")
            },
            Price: {
                number: "Please enter numbers only.",
                min: "Please enter a a value greater than or equal to 10.000",

            }
        }
    });
});