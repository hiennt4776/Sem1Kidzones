$(document).ready(function () {
    $("#frmCreateLevel").validate({
        rules: {
            LevelName: {
                required: true,
                minlength: 5,
                maxlength: 25
            },
            TimeServerMonth: {
                required: true,
                digits: true,
                range: [13, 23]
            }
            
        },
        messages: {

            LevelName: {
                required: "Enter a level name",
                minlength: jQuery.validator.format("Enter at least {0} characters"),
                maxlength: jQuery.validator.format("Enter at maximum {0} characters")
            },
            TimeServerMonth: {
                required: "Enter time for level(by month)",
                digits: "Enter only digits please.",
                range: jQuery.validator.format("Please enter a value between {0} and {1}")
            }  
        }
    });
    $("#frmEditLevel").validate({
        rules: {
            LevelName: {
                required: true,
                minlength: 5,
                maxlength: 25
            },
            TimeServerMonth: {
                required: true,
                digits: true,
                range: [1, 24]
            }

        },
        messages: {

            LevelName: {
                required: "Enter a level name",
                minlength: jQuery.validator.format("Enter at least {0} characters"),
                maxlength: jQuery.validator.format("Enter at maximum {0} characters")
            },
            TimeServerMonth: {
                required: "Enter time for level(by month)",
                digits: "Enter only digits please.",
                range: jQuery.validator.format("Please enter a value between {0} and {1}")
            }
        }
    });
});