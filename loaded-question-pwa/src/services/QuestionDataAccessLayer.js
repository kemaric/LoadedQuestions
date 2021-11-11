export function QuestionDataAccessLayer(options = {}) {
    /**
     * Store for the question bank for any and all games.
     */
    const QuestionStore = {
        "demo-question-hash": {
            questionId: "demo-question",
            tags: ["demo"],
            text: "Demo",
            // store other meta data about the question
            metaData: {}
        }
    };

    this.get = (...questionIds) => {
        throw "Method not implemented";
    };

    this.add = (question) => {
        throw "Method not implemented";
    };


    return this;
}
