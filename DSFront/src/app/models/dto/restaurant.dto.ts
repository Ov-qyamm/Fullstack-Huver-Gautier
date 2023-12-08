export interface RestaurantDto {
    id: number;
    titre: string;
    adresse: string;
    evaluations?: EvaluationDto[];
    moyenne: number;
    evaluationFinale: EvaluationFinaleDto;
  }
  
  export interface EvaluationDto {
    id: number;
    pseudo: string;
    texte: string;
    note: number;
  }

  export interface EvaluationFinaleDto {
    id: number;
    pseudoFinal: string;
    texteFinal: string;
    noteFinale: number;
  }
  