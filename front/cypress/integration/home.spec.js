describe('Homepage', () => {
  beforeEach(() => {
    cy.visit('http://localhost:27000/');
  });
  it('Contains a Users button', () => {
    expect(cy.contains('Users')).toBeTruthy;
  });
  it('Contains a Students button', () => {
    expect(cy.contains('Students')).toBeTruthy;
  });
  it('Contains a Teachers button', () => {
    expect(cy.contains('Teachers')).toBeTruthy;
  });
  it('Returns correct table when teachers button is clicked', () => {
    cy.get('button')
      .contains('Teachers')
      .click();
    expect(cy.contains('TeachersList')).toBeTruthy;
  });
  it('Returns correct table when students button is clicked', () => {
    cy.get('button')
      .contains('Students')
      .click();
    expect(cy.contains('StudentsList')).toBeTruthy;
  });
  it('Returns correct table when users button is clicked', () => {
    cy.get('button')
      .contains('Users')
      .click();
    expect(cy.contains('UsersList')).toBeTruthy;
  });
});
