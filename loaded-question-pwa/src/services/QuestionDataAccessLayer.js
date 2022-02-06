export function QuestionDataAccessLayer (init = {}) {
  /**
     * Store for the question bank for any and all games.
     */
  const { QuestionStore = DEFAULT_QUESTION_STORE() } = init;

  this.get = (questionId) => {
    return QuestionStore[questionId];
  };

  this.add = (question) => {
    throw new Error('Method not implemented');
  };

  this.isNew = (questionText) => {
    const normalizedText = questionText?.toLowerCase().trim();
    return Object
      .values(QuestionStore)
      .find(question => question.text.toLowerCase() === normalizedText) == null;
  }

  return this;
}

const DEFAULT_QUESTION_STORE = () => ({
  'demo-question-hash': {
    questionId: 'demo-question',
    tags: ['demo'],
    text: 'Demo',
    // store other meta data about the question
    metaData: {}
  }
});
