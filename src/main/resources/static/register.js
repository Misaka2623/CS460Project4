(function () {
    "use strict";

    $(function () {
        $("#back").click(function () {
            window.location.href = "index.html";
        });
        $("#password").blur(checkPassword);
        $("#confirm").blur(checkPassword);
    });

    function checkPassword() {
        if ($("#password").val() === $("#confirm").val()) {
            $("#submit").attr("disabled", false);
        } else {
            $("#submit").attr("disabled", true);
        }
    }
})();
