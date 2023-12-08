import React, { useState } from 'react';

function App() {
  const [curQuestion, setCurrentQuestion] = useState(0);
	const [showScore, setShowScore] = useState(false);
	const [score, setScore] = useState(0);

	const questions = [
		{
			question: 'What is the capital of Iraq?',
      image: 'https://wardheernews.com/wp-content/uploads/2016/09/Iraq.jpg',
			answerOptions: [
				{ answerText: 'New York', isCorrect: false },
				{ answerText: 'Cairo', isCorrect: false },
				{ answerText: 'Baghdad', isCorrect: true },
				{ answerText: 'Dhaka', isCorrect: false },
			],
		},
		{
			question: 'What 420 + 69 = ',
      image: 'https://i.redd.it/rhnj6h4yvlt31.jpg',
			answerOptions: [
				{ answerText: 'Nice!', isCorrect: false },
				{ answerText: '489', isCorrect: true },
				{ answerText: '666', isCorrect: false },
				{ answerText: '479', isCorrect: false },
			],
		},
		{
			question: 'Who is the father of the scientific method?',
      image: 'https://independentpress.cc/wp-content/uploads/2021/02/Ibn-al-Haytham-3.jpg',
			answerOptions: [
				{ answerText: 'Sir Francis Bacon', isCorrect: false },
				{ answerText: 'Isaac Newton', isCorrect: false },
				{ answerText: 'Galileo Galilei', isCorrect: false },
				{ answerText: 'Ibn al-Haytham', isCorrect: true },
			],
		},
		{
			question: 'Can conciousness ever be proven imperically?',
      image: 'https://cff2.earth.com/uploads/2023/07/19070331/Consciousness-scaled.jpg',
			answerOptions: [
				{ answerText: 'Absolutely, through objective measurements of brain activity', isCorrect: false },
				{ answerText: 'Yes, through scientific experiments.', isCorrect: false },
				{ answerText: 'Maybe, with advanced technology in the future', isCorrect: false },
				{ answerText: 'No, as it is a metaphysical and subjective concept', isCorrect: true },
			],
		},
		{
			question: "What is the currency of Japan?",
      image: 'https://www.etftrends.com/wp-content/uploads/2022/04/Japanese-Currency-ETF-Plunging-With-USD-at-20-Year-High-Against-Yen.jpg',
			answerOptions: [
			  { answerText: "Yen", isCorrect: true },
			  { answerText: "Won", isCorrect: false },
			  { answerText: "Ringgit", isCorrect: false },
			  { answerText: "Baht", isCorrect: false },
			],
		  },
		  {
			question: "Who wrote 'Romeo and Juliet'?",
      image: 'https://prod-images.tcm.com/Master-Profile-Images/romeoandjuliet1968.452861.jpg',
			answerOptions: [
			  { answerText: "Charles Dickens", isCorrect: false },
			  { answerText: "William Shakespeare", isCorrect: true },
			  { answerText: "Jane Austen", isCorrect: false },
			  { answerText: "Mark Twain", isCorrect: false },
			],
		  },
		  {
			question: "What is the largest planet in our solar system?",
      image: 'https://www.universetoday.com/wp-content/uploads/2014/04/800px-Size_planets_comparison.jpg',
			answerOptions: [
			  { answerText: "Earth", isCorrect: false },
			  { answerText: "Mars", isCorrect: false },
			  { answerText: "Jupiter", isCorrect: true },
			  { answerText: "Saturn", isCorrect: false },
			],
		  },
		  {
			question: "In which year did the Titanic sink?",
      image: 'https://upload.wikimedia.org/wikipedia/commons/f/fd/RMS_Titanic_3.jpg',
			answerOptions: [
			  { answerText: "1910", isCorrect: false },
			  { answerText: "1912", isCorrect: true },
			  { answerText: "1915", isCorrect: false },
			  { answerText: "1920", isCorrect: false },
			],
		  },
		  {
			question: "Who painted the Mona Lisa?",
      image: 'https://pbs.twimg.com/media/GAs99QkXYAAmue0?format=jpg&name=900x900',
			answerOptions: [
			  { answerText: "Vincent van Gogh", isCorrect: false },
			  { answerText: "Leonardo da Vinci", isCorrect: true },
			  { answerText: "Pablo Picasso", isCorrect: false },
			  { answerText: "Michelangelo", isCorrect: false },
			],
		  },
		  {
			question: "What is the capital of Australia?",
      image: 'https://m.media-amazon.com/images/M/MV5BMTA4MTY0NTY3NTNeQTJeQWpwZ15BbWU2MDIzODM3Ng@@._V1_.jpg',
			answerOptions: [
			  { answerText: "Sydney", isCorrect: false },
			  { answerText: "Canberra", isCorrect: true },
			  { answerText: "Melbourne", isCorrect: false },
			  { answerText: "Brisbane", isCorrect: false },
			],
		  },
	];

	const handleAnswerOptionClick = (isCorrect) => {
		if (isCorrect) {
			setScore(score + 1);
		}

		const nextQuestion = curQuestion + 1;
		if (nextQuestion < questions.length) {
			setCurrentQuestion(nextQuestion);
		} else {
			setShowScore(true);
		}
	};
	return (
		<div className='app'>
			{showScore ? (
				<div className='score-section'>
					You scored {score} out of {questions.length}
				</div>
			) : (
				<>
					<div className='question-section'>
						<div className='question-count'>
							<span>Question {curQuestion + 1}</span>/{questions.length}
						</div>
						<div className='question-text'>{questions[curQuestion].image && (
            <img
              src={questions[curQuestion].image}
              alt={`Question ${curQuestion + 1}`}
              className="question-image"
            />
          )}
          {questions[curQuestion].question}
        </div>
      </div>
					<div className='answer-section'>
						{questions[curQuestion].answerOptions.map((answerOption) => (
							<button onClick={() => handleAnswerOptionClick(answerOption.isCorrect)}>{answerOption.answerText}</button>
						))}
					</div>
				</>
			)}
		</div>
	);
}

export default App;
