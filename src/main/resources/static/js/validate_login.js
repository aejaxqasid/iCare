$(document).ready(function () {
  //1. hide error section
  $("#usernameError").hide();
  $("#passwordError").hide();

  //2. set error variable
  var usernameError = false;
  var passwordError = false;

  function validate_username() {
    let val = $("#username").val();
    if (val == "") {
      $("#usernameError").show();
      $("#usernameError").html(
        "*<strong>Username or Email</strong> is required"
      );
      $("#usernameError").addClass("text-danger");
      usernameError = false;
    } else {
      $("#usernameError").hide();
      usernameError = true;
    }
    return usernameError;
  }

  function validate_password() {
    let val = $("#password").val();
    if (val == "") {
      $("#passwordError").show();
      $("#passwordError").html("*<strong>Password</strong> is required");
      $("#passwordError").addClass("text-danger");
      passwordError = false;
    } else {
      $("#passwordError").hide();
      passwordError = true;
    }
    return passwordError;
  }

  $("#username").keyup(function () {
    validate_username();
  });

  $("#password").keyup(function () {
    validate_password();
  });

  //5. validate
  $("#loginForm").submit(function () {
    validate_username();
    validate_password();

    if (usernameError && passwordError) return true;
    else return false;
  });
});
