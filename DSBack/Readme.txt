## Questions

- Concernant la possibilité de modifier une image d'illustration, avez-vous fait une route dédiée au fait de remplacer la photo ou bien considérez-vous qu'il faille simplement appeler la route de suppression puis la route d'ajout ? 

Je n'ai pas eu le temps d'implémenter l'ajout d'image

- Concernant le stockage des images, est-il préférable de mettre d'avoir une seule table contenant tous les IDs de toutes les images (et faire une jointure systématique donc) ou bien vaut-il mieux mettre l'ID de la photo d'illustration dans la table restaurant et ne pas mettre d'ID en DB pour l'image d'illustration d'un restaurant ?

Je n'ai pas eu le temps d'implémenter l'ajout d'image

- Lorsque vous retournez un restaurant, est-ce une bonne idée de retourner la photo systématiquement (via un lien bien sûr) ?

Je n'ai pas eu le temps d'implémenter l'ajout d'image, mais il serait une mauvaise idée de refaire chargé la photo systématiquement, du fait du transfert de données plutot important.

- Lorsque vous retournez un restaurant, est-ce une bonne idée de retourner l'évaluation finale systématiquement ?

Lorsque je retourne un restaurant, je retourne l'évaluation finale à chaque fois. Sachant que cela représente très peu de données, cela ne pose pas de problème.

- Expliquez l'implémentation que vous avez fait des tags (quelles solutions avez-vous envisagées et pourquoi avoir retenu la vôtre en particulier)

Je n'ai pas eu le temps d'implémenter les tags
