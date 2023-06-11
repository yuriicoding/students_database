// Get all the "Change" buttons
const changeButtons = document.querySelectorAll('#change_btn');

// Iterate over each "Change" button
changeButtons.forEach((button) => {
  // Add a click event listener to each button
  button.addEventListener('click', function() {
    // Get the corresponding table row
    const tableRow = this.closest('tr');

    // Get the values from the table row
    const uid = tableRow.querySelector('th').textContent;
    const name = tableRow.querySelector('td:nth-child(2)').textContent;
    const height = tableRow.querySelector('td:nth-child(3)').textContent;
    const weight = tableRow.querySelector('td:nth-child(4)').textContent;
    const hairColor = tableRow.querySelector('td:nth-child(5)').textContent;
    const gpa = tableRow.querySelector('td:nth-child(6)').textContent;

    // Set the values in the modal inputs
    const changeModal = document.getElementById('changeModal');
    changeModal.querySelector('#uid').value = uid;
    changeModal.querySelector('#name').value = name;
    changeModal.querySelector('#height').value = height;
    changeModal.querySelector('#weight').value = weight;
    changeModal.querySelector('#hair_color').value = hairColor;
    changeModal.querySelector('#gpa').value = gpa;

    // Set the "data-bs-whatever" attribute of the modal button
    const modalButton = changeModal.querySelector('.btn-primary');
    modalButton.setAttribute('data-bs-whatever', uid);
  });
});

function submitForm(action) {
    var form = document.getElementById("change_form");
    form.action = action;
    form.method = "get";
    form.submit();
  }
