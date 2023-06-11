const student = document.querySelectorAll(".student-card");

// Iterate over each "Change" button
student.forEach((division) => {
  // Add a click event listener to each button
  division.addEventListener('click', function() {

// Open the change modal
var modal = new bootstrap.Modal(document.getElementById("changeModal"));
modal.show();

// Retrieve the data from the clicked student card
const stored_uid = division.querySelector('#stored_uid').value;
const stored_name = division.querySelector('#stored_name').value;
const stored_height = division.querySelector('#stored_height').value;
const stored_weight = division.querySelector('#stored_weight').value;
const stored_gpa = division.querySelector('#stored_gpa').value;
const stored_hair_color = division.querySelector('#stored_hair_color').value;

// Update the values in the change modal
const changeModal = document.getElementById('changeModal');
changeModal.querySelector('#uid').value = stored_uid;
changeModal.querySelector('#name').value = stored_name;
changeModal.querySelector('#height').value = stored_height;
changeModal.querySelector('#weight').value = stored_weight;
changeModal.querySelector('#hair_color').value = stored_hair_color;
changeModal.querySelector('#gpa').value = stored_gpa;
    
});
});

function submitForm(action) {
    var form = document.getElementById("change_form");
    form.action = action;
    form.method = "get";
    form.submit();
  }
