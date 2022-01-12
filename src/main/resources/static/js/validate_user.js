$(document).ready(function () {

  //1. hide error section
  $("#displayNameError").hide();
  $("#usernameError").hide();
  $("#passwordError").hide();
  $("#roleError").hide();


  //2. set error variable
  var displayNameError = false;
  var usernameError = false;
  var passwordError = false;
  var roleError = false;


  //3. validation function
  function validate_display_name() {
    let val = $("#displayName").val();
    let regex = /^[A-Za-z\s]*$/;
    if (val == "") {
      $("#displayNameError").show();
      $("#displayNameError").html("*<strong>Name</strong> is required");
      $("#displayNameError").addClass("text-danger");
      displayNameError = false;
    } else if (!regex.test(val)) {
      $("#displayNameError").show();
      $("#displayNameError").html(
        "*Only English Aphabets and white space are allowed"
      );
      $("#displayNameError").addClass("text-danger");
      displayNameError = false;
    } else {
      $("#displayNameError").hide();
      displayNameError = true;
    }
    return displayNameError;
  }

  function validate_username() {
    let val = $("#username").val();
    let regex = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9]+\.[A-Za-z]{2,4}$/;
    if (val == "") {
      $("#usernameError").show();
      $("#usernameError").html("*<strong>Username or Email</strong> is required");
      $("#usernameError").addClass("text-danger");
      usernameError = false;
    } else if (!regex.test(val)) {
      $("#usernameError").show();
      $("#usernameError").html("*invalid username!");
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
    let regex = /^[A-Za-z0-9]*$/;
    if (val == "") {
      $("#passwordError").show();
      $("#passwordError").html("*<strong>Password</strong> is required");
      $("#passwordError").addClass("text-danger");
      passwordError = false;
    } else if (!regex.test(val)) {
      $("#passwordError").show();
      $("#passwordError").html(
        "*Only English Aphabets are and digits are allowed"
      );
      $("#passwordError").addClass("text-danger");
      passwordError = false;
    } else {
      $("#passwordError").hide();
      passwordError = true;
    }
    return passwordError;
  }

  function validate_role() {
    let val = $("input[name='role']:checked").val();
    if (val == undefined) {
      $("#roleError").show();
      $("#roleError").html("*<strong>Role</strong> is required");
      $("#roleError").addClass("text-danger");
      roleError = false;
    } else {
      roleError = true;
      $("#roleError").hide();
    }
    return roleError;
  }


  //4. activation listener
  $("#displayName").keyup(function () {
    validate_display_name();
  });

  $("#username").keyup(function () {
    validate_username();
  });

  $("#password").keyup(function () {
    validate_password();
  });


  //5. validate
  $("#userForm").submit(function () {
   
    validate_display_name();
    validate_username();
    validate_password();
    validate_role();

    if (
      displayNameError && usernameError && passwordError && roleError
    )
      return true;
    else return false;
  });
});
