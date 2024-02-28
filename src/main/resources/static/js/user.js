window.onload = function (){
    getContentsByPage();
    getDepartmentList();
    getPositionList();
}

function checkPasswords() {
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('repassword').value;
    var errorText = document.getElementById('errorText');

    if (password !== confirmPassword) {
        errorText.style.display = 'block';
    } else {
        errorText.style.display = 'none';
        // Tiếp tục xử lý nếu mật khẩu khớp
    }
}

let listDepartment = "";
// Lấy giá trị của department thành Id trong modal
function getDepartmentData() {
    let departmentSelect = document.getElementById("department-select");
    let departmentOptions = Array.from(departmentSelect.options);

    departmentOptions.map(function(option) {
        listDepartment += option.value;
    });
    return listDepartment;
}

// Tao user mới

$('#btnAdd').click(function() {

    let loginName = $('#loginName').val();
    let pass = $('#password').val();
    let fname = $('#firstName').val();
    let lname = $('#lastName').val();
    let fnameF = $('#firstNameF').val();
    let lnamF = $('#lastNameF').val();
    let email = $('#email').val();
    let outTelephone = $('.NumO1').val() + $('.NumO2').val() + $('.NumO3').val();
    let inPhone = $('#InPhone').val();
    let cellPhone = $('.cellPhone1').val() + $('.cellPhone2').val() + $('.cellPhone3').val();
    let cellMail = $('#cellMail').val();

    let departmentId = getDepartmentData();
    listDepartment = "";
    let positionId = $('#position').val();


    $.ajax({
        url: "http://localhost:8080/create",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify({
            "loginName": loginName,
            "password": pass,
            "firstName": fname,
            "lastName": lname,
            "inTelephone": inPhone,
            "outTelephone": outTelephone,
            "cellularPhone": cellPhone,
            "cellularMail": cellMail,
            "email": email,
            "firstNameKana": fnameF,
            "lastNameKana": lnamF,
            "post" : {"id" : departmentId },
            "position" : {"id" : positionId }
        }),
        success: function(response) {
            console.log(response);
            if(Object.keys(response).length === 0 ){
                alert("Email or loginName already exist");
            }
            $('#exampleModal').modal('toggle');
            if(response != null){
                alert("Sign up successfully")

                // Reset các trường dữ liệu
                $('#loginName').val('');
                $('#password').val('');
                $('#repassword').val('');
                $('#firstName').val('');
                $('#lastName').val('');
                $('#firstNameF').val('');
                $('#lastNameF').val('');
                $('#email').val('');
                $('.NumO1').val('');
                $('.NumO2').val('');
                $('.NumO3').val('');
                $('#InPhone').val('');
                $('.cellPhone1').val('');
                $('.cellPhone2').val('');
                $('.cellPhone3').val('');
                $('#cellMail').val('');
                $('#department-select').empty().val([]);
            }

            getContentsByPage();
        }
    });
});

// lấy list User từ DB
function getContentsByPage() {
    $.ajax({
        url: "http://localhost:8080/users",
        method: "GET",
        contentType: "application/json",
        success: function (response) {

            showListUser(response)
        }
    });
}

function showListUser(response ){
    let data= '';

    response.forEach(function (content){

        let template = `  <tr>
                              <td style="width: 50px;"><input type="checkbox" name=""></td>
                              <td style="width: 150px;">Effectiveness</td>
                              <td style="width: 400px;">${content.loginName}</td>
                              <td style="width: 300px;">${content.firstName} ${content.lastName} </td>
                              <td style="width: 400px;">${content.post.namePost}</td>
                              <td style="width: 100px;"></td>
                          </tr>`;
        data += template;
    });

    $('tbody').html(data);
}
function moveSelectedOptions() {
    let selectDepartmentList = document.getElementById("select-department");
    let departmentSelect = document.getElementById("department-select");

    // Lấy các phần tử đã chọn
    let selectedOptions = Array.from(selectDepartmentList.selectedOptions);

    // Kiểm tra giới hạn độ dài
    if (selectedOptions.length > 0) {
        // Xóa phần tử hiện có trong "department-select"
        while (departmentSelect.options.length > 0) {
            departmentSelect.remove(0);
        }

        // Di chuyển phần tử đầu tiên đã chọn từ "select-department" sang "department-select"
        departmentSelect.add(selectedOptions[0].cloneNode(true));
    }
}

function moveOptions() {
    let departmentSelect = document.getElementById("department-select");

    // Xóa các phần tử đã chọn khỏi Department
    for (let i = departmentSelect.options.length - 1; i >= 0; i--) {
        if (departmentSelect.options[i].selected) {
            departmentSelect.remove(i);
        }
    }
}

// Lấy list DepartMent Name từ DB
function getDepartmentList(){
    $.ajax({
        url: "http://localhost:8080/departments",
        method: "GET",
        contentType: "application/json",
        success: function (response) {

            let option= '<option value="0"></option>';
            response.forEach(function (d){
                let template = ` <option value="${d.id}">${d.namePost}</option> `;
                option += template;
            });
            $('#searchUser-department').html(option);

            let data= '';
            response.forEach(function (d){
                let template = `<option value="${d.id}" >${d.namePost}</option>`;
                data += template;
            });
            $('#select-department').html(data);
        }
    })
}

function getPositionList() {
    $.ajax({
        url: "/positions", // Đường dẫn URL của API positions
        method: "GET",
        contentType: "application/json",
        success: function(response) {
            let option = '';
            response.forEach(function(p) {
                let template = `<option value="${p.id}">${p.name}</option>`;
                option += template;
            });
            $('#position').html(option);
        }
    });
}

$('#btn-search').click(function () {
    let departmentId = $('#searchUser-department').val();
    console.log(departmentId);

    if (departmentId === "0") {
        return location.reload();
    }
    $.ajax({
        url: "http://localhost:8080/search-users",
        method: "GET",
        contentType: "application/json",
        data: { id : departmentId },
        success: function (response) {
            showListUser(response);
        }
    });
});


