import React from 'react';
import { render, fireEvent } from '@testing-library/react';
import App from './App';

test('renders the first question', () => {
  const { getByText } = render(<App />);
  const questionText = getByText(/What is the capital of Iraq?/i);
  expect(questionText).toBeInTheDocument();
});

test('selects the correct answer and advances to the next question', () => {
  const { getByText } = render(<App />);
  // Select the correct answer for the first question
  fireEvent.click(getByText(/Baghdad/i));

  // Check if the next question is displayed
  const nextQuestionText = getByText(/What 420 \+ 69 =/i);
  expect(nextQuestionText).toBeInTheDocument();
});

test('displays the final score at the end of the quiz', () => {
  const { getByText } = render(<App />);
  // Answer all questions
  fireEvent.click(getByText(/Baghdad/i));
  fireEvent.click(getByText(/489/i));
  fireEvent.click(getByText(/Ibn al-Haytham/i));
  fireEvent.click(getByText(/No, as it is a metaphysical and subjective concept/i));
  fireEvent.click(getByText(/Yen/i));
  fireEvent.click(getByText(/William Shakespeare/i));
  fireEvent.click(getByText(/Jupiter/i));
  fireEvent.click(getByText(/1912/i));
  fireEvent.click(getByText(/Leonardo da Vinci/i));
  fireEvent.click(getByText(/Canberra/i));

  // Check if the final score is displayed
  const finalScoreText = getByText(/You scored 10 out of 10/i);
  expect(finalScoreText).toBeInTheDocument();
});
