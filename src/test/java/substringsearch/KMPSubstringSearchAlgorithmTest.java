package substringsearch;

import entity.Result;
import org.junit.Before;
import org.junit.Test;

public class KMPSubstringSearchAlgorithmTest {
    String text1 = "In my younger and more vulnerable years my father gave me some advice\n" +
            "that I've been turning over in my mind ever since.\n" +
            "\n" +
            "\"Whenever you feel like criticizing any one,\" he told me, \"just\n" +
            "remember that all the people in this world haven't had the advantages\n" +
            "that you've had.\"\n" +
            "\n" +
            "He didn't say any more but we've always been unusually communicative\n" +
            "in a reserved way, and I understood that he meant a great deal more\n" +
            "than that. In consequence I'm inclined to reserve all judgments,\n" +
            "a habit that has opened up many curious natures to me and also\n" +
            "made me the victim of not a few veteran bores. The abnormal mind\n" +
            "is quick to detect and attach itself to this quality when it\n" +
            "appears in a normal person, and so it came about that in college I\n" +
            "was unjustly accused of being a politician, because I was privy to the\n" +
            "secret griefs of wild, unknown men. Most of the confidences were\n" +
            "unsought--frequently I have feigned sleep, preoccupation, or a hostile\n" +
            "levity when I realized by some unmistakable sign that an intimate\n" +
            "revelation was quivering on the horizon--for the intimate revelations\n" +
            "of young men or at least the terms in which they express them are\n" +
            "usually plagiaristic and marred by obvious suppressions. Reserving\n" +
            "judgments is a matter of infinite hope. I am still a little afraid of\n" +
            "missing something if I forget that, as my father snobbishly suggested,\n" +
            "and I snobbishly repeat a sense of the fundamental decencies is\n" +
            "parcelled out unequally at birth.\n" +
            "\n" +
            "And, after boasting this way of my tolerance, I come to the admission\n" +
            "that it has a limit. Conduct may be founded on the hard rock or the wet\n" +
            "marshes but after a certain point I don't care what it's founded on.\n" +
            "When I came back from the East last autumn I felt that I wanted the\n" +
            "world to be in uniform and at a sort of moral attention forever; I\n" +
            "wanted no more riotous excursions with privileged glimpses into the\n" +
            "human heart. Only Gatsby, the man who gives his name to this book, was\n" +
            "exempt from my reaction--Gatsby who represented everything for which I\n" +
            "have an unaffected scorn. If personality is an unbroken series of\n" +
            "successful gestures, then there was something gorgeous about him, some\n" +
            "heightened sensitivity to the promises of life, as if he were related\n" +
            "to one of those intricate machines that register earthquakes ten\n" +
            "thousand miles away. This responsiveness had nothing to do with that\n" +
            "flabby impressionability which is dignified under the name of the\n" +
            "\"creative temperament\"--it was an extraordinary gift for hope, a romantic\n" +
            "readiness such as I have never found in any other person and which it\n" +
            "is not likely I shall ever find again. No--Gatsby turned out all right\n" +
            "at the end; it is what preyed on Gatsby, what foul dust floated in the\n" +
            "wake of his dreams that temporarily closed out my interest in the\n" +
            "abortive sorrows and short-winded elations of men.\n" +
            "\n" +
            "\n" +
            "My family have been prominent, well-to-do people in this middle-western\n" +
            "city for three generations. The Carraways are something of a clan and we\n" +
            "have a tradition that we're descended from the Dukes of Buccleuch, but the\n" +
            "actual founder of my line was my grandfather's brother who came here in\n" +
            "fifty-one, sent a substitute to the Civil War and started the wholesale\n" +
            "hardware business that my father carries on today.\n" +
            "\n" +
            "I never saw this great-uncle but I'm supposed to look like him--with\n" +
            "special reference to the rather hard-boiled painting that hangs in\n" +
            "Father's office. I graduated from New Haven in 1915, just a quarter of a\n" +
            "century after my father, and a little later I participated in that\n" +
            "delayed Teutonic migration known as the Great War. I enjoyed the\n" +
            "counter-raid so thoroughly that I came back restless. Instead of being\n" +
            "the warm center of the world the middle-west now seemed like the\n" +
            "ragged edge of the universe--so I decided to go east and learn the bond\n" +
            "business. Everybody I knew was in the bond business so I supposed it\n" +
            "could support one more single man. All my aunts and uncles talked it\n" +
            "over as if they were choosing a prep-school for me and finally said,\n" +
            "\"Why--ye-es\" with very grave, hesitant faces. Father agreed to finance\n" +
            "me for a year and after various delays I came east, permanently, I\n" +
            "thought, in the spring of twenty-two.\n" +
            "\n" +
            "The practical thing was to find rooms in the city but it was a warm\n" +
            "season and I had just left a country of wide lawns and friendly trees,\n" +
            "so when a young man at the office suggested that we take a house\n" +
            "together in a commuting town it sounded like a great idea. He found\n" +
            "the house, a weather beaten cardboard bungalow at eighty a month, but\n" +
            "at the last minute the firm ordered him to Washington and I went out\n" +
            "to the country alone. I had a dog, at least I had him for a few days\n" +
            "until he ran away, and an old Dodge and a Finnish woman who made my bed\n" +
            "and cooked breakfast and muttered Finnish wisdom to herself over the\n" +
            "electric stove.\n" +
            "\n" +
            "It was lonely for a day or so until one morning some man, more recently\n" +
            "arrived than I, stopped me on the road.\n" +
            "\n" +
            "\"How do you get to West Egg village?\" he asked helplessly.\n" +
            "\n" +
            "I told him. And as I walked on I was lonely no longer. I was a guide, a\n" +
            "pathfinder, an original settler. He had casually conferred on me the\n" +
            "freedom of the neighborhood.\n" +
            "\n" +
            "And so with the sunshine and the great bursts of leaves growing on the\n" +
            "trees--just as things grow in fast movies--I had that familiar\n" +
            "conviction that life was beginning over again with the summer.\n" +
            "\n" +
            "There was so much to read for one thing and so much fine health to be\n" +
            "pulled down out of the young breath-giving air. I bought a dozen\n" +
            "volumes on banking and credit and investment securities and they stood\n" +
            "on my shelf in red and gold like new money from the mint, promising to\n" +
            "unfold the shining secrets that only Midas and Morgan and Maecenas\n" +
            "knew. And I had the high intention of reading many other books besides.\n" +
            "I was rather literary in college--one year I wrote a series of very\n" +
            "solemn and obvious editorials for the \"Yale News\"--and now I was going\n" +
            "to bring back all such things into my life and become again that most\n" +
            "limited of all specialists, the \"well-rounded man.\" This isn't just an\n" +
            "epigram--life is much more successfully looked at from a single window,\n" +
            "after all.\n" +
            "\n" +
            "It was a matter of chance that I should have rented a house in one of\n" +
            "the strangest communities in North America. It was on that slender\n" +
            "riotous island which extends itself due east of New York and where\n" +
            "there are, among other natural curiosities, two unusual formations of\n" +
            "land. Twenty miles from the city a pair of enormous eggs, identical in\n" +
            "contour and separated only by a courtesy bay, jut out into the most\n" +
            "domesticated body of salt water in the Western Hemisphere, the great\n" +
            "wet barnyard of Long Island Sound. They are not perfect ovals--like the\n" +
            "egg in the Columbus story they are both crushed flat at the contact\n" +
            "end--but their physical resemblance must be a source of perpetual\n" +
            "confusion to the gulls that fly overhead. To the wingless a more\n" +
            "arresting phenomenon is their dissimilarity in every particular except\n" +
            "shape and size.\n" +
            "\n" +
            "I lived at West Egg, the--well, the less fashionable of the two, though\n" +
            "this is a most superficial tag to express the bizarre and not a little\n" +
            "sinister contrast between them. My house was at the very tip of the\n" +
            "egg, only fifty yards from the Sound, and squeezed between two huge\n" +
            "places that rented for twelve or fifteen thousand a season. The one on\n" +
            "my right was a colossal affair by any standard--it was a factual\n" +
            "imitation of some Hôtel de Ville in Normandy, with a tower on one side,\n" +
            "spanking new under a thin beard of raw ivy, and a marble swimming pool\n" +
            "and more than forty acres of lawn and garden. It was Gatsby's mansion.\n" +
            "Or rather, as I didn't know Mr. Gatsby it was a mansion inhabited by\n" +
            "a gentleman of that name. My own house was an eye-sore, but it was a\n" +
            "small eye-sore, and it had been overlooked, so I had a view of the\n" +
            "water, a partial view of my neighbor's lawn, and the consoling\n" +
            "proximity of millionaires--all for eighty dollars a month.\n" +
            "\n" +
            "Across the courtesy bay the white palaces of fashionable East Egg\n" +
            "glittered along the water, and the history of the summer really begins\n" +
            "on the evening I drove over there to have dinner with the Tom\n" +
            "Buchanans. Daisy was my second cousin once removed and I'd known Tom\n" +
            "in college. And just after the war I spent two days with them in\n" +
            "Chicago.\n" +
            "\n" +
            "Her husband, among various physical accomplishments, had been one of\n" +
            "the most powerful ends that ever played football at New Haven--a\n" +
            "national figure in a way, one of those men who reach such an acute\n" +
            "limited excellence at twenty-one that everything afterward savors of\n" +
            "anti-climax. His family were enormously wealthy--even in college his\n" +
            "freedom with money was a matter for reproach--but now he'd left Chicago\n" +
            "and come east in a fashion that rather took your breath away: for\n" +
            "instance he'd brought down a string of polo ponies from Lake Forest.\n" +
            "It was hard to realize that a man in my own generation was wealthy\n" +
            "enough to do that.\n" +
            "\n" +
            "Why they came east I don't know. They had spent a year in France, for no\n" +
            "particular reason, and then drifted here and there unrestfully wherever\n" +
            "people played polo and were rich together. This was a permanent move,\n" +
            "said Daisy over the telephone, but I didn't believe it--I had no sight\n" +
            "into Daisy's heart but I felt that Tom would drift on forever seeking\n" +
            "a little wistfully for the dramatic turbulence of some irrecoverable\n" +
            "football game.\n" +
            "\n" +
            "And so it happened that on a warm windy evening I drove over to East\n" +
            "Egg to see two old friends whom I scarcely knew at all. Their house was\n" +
            "even more elaborate than I expected, a cheerful red and white Georgian\n" +
            "Colonial mansion overlooking the bay. The lawn started at the beach\n" +
            "and ran toward the front door for a quarter of a mile, jumping over\n" +
            "sun-dials and brick walks and burning gardens--finally when it reached\n" +
            "the house drifting up the side in bright vines as though from the\n" +
            "momentum of its run. The front was broken by a line of French windows,\n" +
            "glowing now with reflected gold, and wide open to the warm windy\n" +
            "afternoon, and Tom Buchanan in riding clothes was standing with his\n" +
            "legs apart on the front porch.\n" +
            "\n" +
            "He had changed since his New Haven years. Now he was a sturdy, straw haired\n" +
            "man of thirty with a rather hard mouth and a supercilious manner.\n" +
            "Two shining, arrogant eyes had established dominance over his face and\n" +
            "gave him the appearance of always leaning aggressively forward. Not\n" +
            "even the effeminate swank of his riding clothes could hide the enormous\n" +
            "power of that body--he seemed to fill those glistening boots until he\n" +
            "strained the top lacing and you could see a great pack of muscle\n" +
            "shifting when his shoulder moved under his thin coat. It was a body\n" +
            "capable of enormous leverage--a cruel body.\n" +
            "\n" +
            "His speaking voice, a gruff husky tenor, added to the impression of\n" +
            "fractiousness he conveyed. There was a touch of paternal contempt in\n" +
            "it, even toward people he liked--and there were men at New Haven who had\n" +
            "hated his guts.\n" +
            "\n" +
            "\"Now, don't think my opinion on these matters is final,\" he seemed to\n" +
            "say, \"just because I'm stronger and more of a man than you are.\" We\n" +
            "were in the same Senior Society, and while we were never intimate I\n" +
            "always had the impression that he approved of me and wanted me to like\n" +
            "him with some harsh, defiant wistfulness of his own.\n" +
            "\n" +
            "We talked for a few minutes on the sunny porch.\n" +
            "\n" +
            "\"I've got a nice place here,\" he said, his eyes flashing about\n" +
            "restlessly.\n" +
            "\n" +
            "Turning me around by one arm he moved a broad flat hand along the\n" +
            "front vista, including in its sweep a sunken Italian garden, a half\n" +
            "acre of deep pungent roses and a snub-nosed motor boat that bumped\n" +
            "the tide off shore.\n" +
            "\n" +
            "\"It belonged to Demaine the oil man.\" He turned me around again,\n" +
            "politely and abruptly. \"We'll go inside.\"\n" +
            "\n" +
            "We walked through a high hallway into a bright rosy-colored space,\n" +
            "fragilely bound into the house by French windows at either end.\n" +
            "The windows were ajar and gleaming white against the fresh grass\n" +
            "outside that seemed to grow a little way into the house. A breeze\n" +
            "blew through the room, blew curtains in at one end and out the other\n" +
            "like pale flags, twisting them up toward the frosted wedding cake of\n" +
            "the ceiling--and then rippled over the wine-colored rug, making a\n" +
            "shadow on it as wind does on the sea.\n" +
            "\n" +
            "The only completely stationary object in the room was an enormous couch\n" +
            "on which two young women were buoyed up as though upon an anchored\n" +
            "balloon. They were both in white and their dresses were rippling and\n" +
            "fluttering as if they had just been blown back in after a short flight\n" +
            "around the house. I must have stood for a few moments listening to the\n" +
            "whip and snap of the curtains and the groan of a picture on the wall.\n" +
            "Then there was a boom as Tom Buchanan shut the rear windows and the caught\n" +
            "wind died out about the room and the curtains and the rugs and the two\n" +
            "young women ballooned slowly to the floor.\n" +
            "\n" +
            "The younger of the two was a stranger to me. She was extended full length\n" +
            "at her end of the divan, completely motionless and with her chin raised\n" +
            "a little as if she were balancing something on it which was quite likely\n" +
            "to fall. If she saw me out of the corner of her eyes she gave no hint of\n" +
            "it--indeed, I was almost surprised into murmuring an apology for having\n" +
            "disturbed her by coming in.\n" +
            "\n" +
            "The other girl, Daisy, made an attempt to rise--she leaned slightly\n" +
            "forward with a conscientious expression--then she laughed, an absurd,\n" +
            "charming little laugh, and I laughed too and came forward into the\n" +
            "room.\n" +
            "\n" +
            "\"I'm p-paralyzed with happiness.\"\n" +
            "\n" +
            "She laughed again, as if she said something very witty, and held my hand\n" +
            "for a moment, looking up into my face, promising that there was no one\n" +
            "in the world she so much wanted to see. That was a way she had.\n" +
            "She hinted in a murmur that the surname of the balancing girl was Baker.\n" +
            "(I've heard it said that Daisy's murmur was only to make people\n" +
            "lean toward her; an irrelevant criticism that made it no less charming.)\n" +
            "\n" +
            "At any rate Miss Baker's lips fluttered, she nodded at me almost\n" +
            "imperceptibly and then quickly tipped her head back again--the object\n" +
            "she was balancing had obviously tottered a little and given her something\n" +
            "of a fright. Again a sort of apology arose to my lips. Almost any\n" +
            "exhibition of complete self sufficiency draws a stunned tribute from me.\n" +
            "\n" +
            "I looked back at my cousin who began to ask me questions in her low,\n" +
            "thrilling voice. It was the kind of voice that the ear follows up and\n" +
            "down as if each speech is an arrangement of notes that will never be\n" +
            "played again. Her face was sad and lovely with bright things in it,\n" +
            "bright eyes and a bright passionate mouth--but there was an excitement\n" +
            "in her voice that men who had cared for her found difficult to forget:\n" +
            "a singing compulsion, a whispered \"Listen,\" a promise that she had done\n" +
            "gay, exciting things just a while since and that there were gay,\n" +
            "exciting things hovering in the next hour.\n" +
            "\n" +
            "I told her how I had stopped off in Chicago for a day on my way east\n" +
            "and how a dozen people had sent their love through me.\n" +
            "\n" +
            "\"Do they miss me?\" she cried ecstatically.\n" +
            "\n" +
            "\"The whole town is desolate. All the cars have the left rear wheel\n" +
            "painted black as a mourning wreath and there's a persistent wail all\n" +
            "night along the North Shore.\"\n" +
            "\n" +
            "\"How gorgeous! Let's go back, Tom. Tomorrow!\" Then she added\n" +
            "irrelevantly, \"You ought to see the baby.\"\n" +
            "\n" +
            "\"I'd like to.\"\n" +
            "\n" +
            "\"She's asleep. She's two years old. Haven't you ever seen her?\"\n" +
            "\n" +
            "\"Never.\"\n" +
            "\n" +
            "\"Well, you ought to see her. She's----\"\n" +
            "\n" +
            "Tom Buchanan who had been hovering restlessly about the room stopped\n" +
            "and rested his hand on my shoulder.\n" +
            "\n" +
            "\"What you doing, Nick?\"\n" +
            "\n" +
            "\"I'm a bond man.\"\n" +
            "\n" +
            "\"Who with?\"\n" +
            "\n" +
            "I told him.\n" +
            "\n" +
            "\"Never heard of them,\" he remarked decisively.\n" +
            "\n" +
            "This annoyed me.\n" +
            "\n" +
            "\"You will,\" I answered shortly. \"You will if you stay in the East.\"\n" +
            "\n" +
            "\"Oh, I'll stay in the East, don't you worry,\" he said, glancing at\n" +
            "Daisy and then back at me, as if he were alert for something more.\n" +
            "\"I'd be a God Damned fool to live anywhere else.\"\n" +
            "\n" +
            "At this point Miss Baker said \"Absolutely!\" with such suddenness that I\n" +
            "started--it was the first word she uttered since I came into the room.\n" +
            "Evidently it surprised her as much as it did me, for she yawned and\n" +
            "with a series of rapid, deft movements stood up into the room.\n" +
            "\n" +
            "\"I'm stiff,\" she complained, \"I've been lying on that sofa for as long\n" +
            "as I can remember.\"\n" +
            "\n" +
            "\"Don't look at me,\" Daisy retorted. \"I've been trying to get you to New\n" +
            "York all afternoon.\"\n" +
            "\n" +
            "\"No, thanks,\" said Miss Baker to the four cocktails just in from the\n" +
            "pantry, \"I'm absolutely in training.\"\n" +
            "\n" +
            "Her host looked at her incredulously.\n" +
            "\n" +
            "\"You are!\" He took down his drink as if it were a drop in the bottom of\n" +
            "a glass. \"How you ever get anything done is beyond me.\"\n" +
            "\n" +
            "I looked at Miss Baker wondering what it was she \"got done.\" I enjoyed\n" +
            "looking at her. She was a slender, small-breasted girl, with an erect\n" +
            "carriage which she accentuated by throwing her body backward at the\n" +
            "shoulders like a young cadet. Her grey sun-strained eyes looked back at\n" +
            "me with polite reciprocal curiosity out of a wan, charming discontented\n" +
            "face. It occurred to me now that I had seen her, or a picture of her,\n" +
            "somewhere before.\n" +
            "\n" +
            "\"You live in West Egg,\" she remarked contemptuously. \"I know somebody\n" +
            "there.\"\n" +
            "\n" +
            "\"I don't know a single----\"\n" +
            "\n" +
            "\"You must know Gatsby.\"\n" +
            "\n" +
            "\"Gatsby?\" demanded Daisy. \"What Gatsby?\"\n" +
            "\n" +
            "Before I could reply that he was my neighbor dinner was announced;\n" +
            "wedging his tense arm imperatively under mine Tom Buchanan compelled\n" +
            "me from the room as though he were moving a checker to another square.\n" +
            "\n" +
            "Slenderly, languidly, their hands set lightly on their hips the two\n" +
            "young women preceded us out onto a rosy-colored porch open toward the\n" +
            "sunset where four candles flickered on the table in the diminished\n" +
            "wind.\n" +
            "\n" +
            "\"Why CANDLES?\" objected Daisy, frowning. She snapped them out with her\n" +
            "fingers. \"In two weeks it'll be the longest day in the year.\"\n" +
            "She looked at us all radiantly. \"Do you always watch for the longest day\n" +
            "of the year and then miss it? I always watch for the longest day in the\n" +
            "year and then miss it.\"\n" +
            "\n" +
            "\"We ought to plan something,\" yawned Miss Baker, sitting down at the\n" +
            "table as if she were getting into bed.\n" +
            "\n" +
            "\"All right,\" said Daisy. \"What'll we plan?\" She turned to me helplessly.\n" +
            "\"What do people plan?\"\n" +
            "\n" +
            "Before I could answer her eyes fastened with an awed expression on her\n" +
            "little finger.\n" +
            "\n" +
            "\"Look!\" she complained. \"I hurt it.\"\n" +
            "\n" +
            "We all looked--the knuckle was black and blue.\n" +
            "\n" +
            "\"You did it, Tom,\" she said accusingly. \"I know you didn't mean to\n" +
            "but you DID do it. That's what I get for marrying a brute of a man,\n" +
            "a great big hulking physical specimen of a----\"\n" +
            "\n" +
            "\"I hate that word hulking,\" objected Tom crossly, \"even in kidding.\"\n" +
            "\n" +
            "\"Hulking,\" insisted Daisy.\n" +
            "\n" +
            "Sometimes she and Miss Baker talked at once, unobtrusively and with a\n" +
            "bantering inconsequence that was never quite chatter, that was as cool\n" +
            "as their white dresses and their impersonal eyes in the absence of all\n" +
            "desire. They were here--and they accepted Tom and me, making only a\n" +
            "polite pleasant effort to entertain or to be entertained. They knew\n" +
            "that presently dinner would be over and a little later the evening too\n" +
            "would be over and casually put away. It was sharply different from the\n" +
            "West where an evening was hurried from phase to phase toward its\n" +
            "close in a continually disappointed anticipation or else in sheer\n" +
            "nervous dread of the moment itself.\n" +
            "\n" +
            "\"You make me feel uncivilized, Daisy,\" I confessed on my second glass\n" +
            "of corky but rather impressive claret. \"Can't you talk about crops or\n" +
            "something?\"\n" +
            "\n" +
            "I meant nothing in particular by this remark but it was taken up in an\n" +
            "unexpected way.\n" +
            "\n" +
            "\"Civilization's going to pieces,\" broke out Tom violently.\n" +
            "\"I've gotten to be a terrible pessimist about things. Have you read\n" +
            "'The Rise of the Coloured Empires' by this man Goddard?\"\n" +
            "\n" +
            "\"Why, no,\" I answered, rather surprised by his tone.\n" +
            "\n" +
            "\"Well, it's a fine book, and everybody ought to read it. The idea is if\n" +
            "we don't look out the white race will be--will be utterly submerged.\n" +
            "It's all scientific stuff; it's been proved.\"\n" +
            "\n" +
            "\"Tom's getting very profound,\" said Daisy with an expression of\n" +
            "unthoughtful sadness. \"He reads deep books with long words in them.\n" +
            "What was that word we----\"\n" +
            "\n" +
            "\"Well, these books are all scientific,\" insisted Tom, glancing at her\n" +
            "impatiently. \"This fellow has worked out the whole thing. It's up to us\n" +
            "who are the dominant race to watch out or these other races will have\n" +
            "control of things.\"\n" +
            "\n" +
            "\"We've got to beat them down,\" whispered Daisy, winking ferociously\n" +
            "toward the fervent sun.\n" +
            "\n" +
            "\"You ought to live in California--\" began Miss Baker but Tom\n" +
            "interrupted her by shifting heavily in his chair.\n" +
            "\n" +
            "\"This idea is that we're Nordics. I am, and you are and you are\n" +
            "and----\" After an infinitesimal hesitation he included Daisy with a\n" +
            "slight nod and she winked at me again. \"--and we've produced all the\n" +
            "things that go to make civilization--oh, science and art and all that.\n" +
            "Do you see?\"\n" +
            "\n" +
            "There was something pathetic in his concentration as if his complacency,\n" +
            "more acute than of old, was not enough to him any more. When, almost\n" +
            "immediately, the telephone rang inside and the butler left the porch Daisy\n" +
            "seized upon the momentary interruption and leaned toward me.\n" +
            "\n" +
            "\"I'll tell you a family secret,\" she whispered enthusiastically. \"It's\n" +
            "about the butler's nose. Do you want to hear about the butler's nose?\"\n" +
            "\n" +
            "\"That's why I came over tonight.\"\n" +
            "\n" +
            "\"Well, he wasn't always a butler; he used to be the silver polisher for\n" +
            "some people in New York that had a silver service for two hundred people.\n" +
            "He had to polish it from morning till night until finally it began to\n" +
            "affect his nose----\"\n" +
            "\n" +
            "\"Things went from bad to worse,\" suggested Miss Baker.\n" +
            "\n" +
            "\"Yes. Things went from bad to worse until finally he had to give up\n" +
            "his position.\"\n" +
            "\n" +
            "For a moment the last sunshine fell with romantic affection upon\n" +
            "her glowing face; her voice compelled me forward breathlessly as\n" +
            "I listened--then the glow faded, each light deserting her with\n" +
            "lingering regret like children leaving a pleasant street at dusk.\n" +
            "\n" +
            "The butler came back and murmured something close to Tom's ear\n" +
            "whereupon Tom frowned, pushed back his chair and without a word went\n" +
            "inside. As if his absence quickened something within her Daisy leaned\n" +
            "forward again, her voice glowing and singing.\n" +
            "\n" +
            "\"I love to see you at my table, Nick. You remind me of a--of a rose, an\n" +
            "absolute rose. Doesn't he?\" She turned to Miss Baker for confirmation.\n" +
            "\"An absolute rose?\"\n" +
            "\n" +
            "This was untrue. I am not even faintly like a rose. She was only\n" +
            "extemporizing but a stirring warmth flowed from her as if her\n" +
            "heart was trying to come out to you concealed in one of those\n" +
            "breathless, thrilling words. Then suddenly she threw her napkin on the\n" +
            "table and excused herself and went into the house.\n" +
            "\n" +
            "Miss Baker and I exchanged a short glance consciously devoid of\n" +
            "meaning. I was about to speak when she sat up alertly and said \"Sh!\" in\n" +
            "a warning voice. A subdued impassioned murmur was audible in the room\n" +
            "beyond and Miss Baker leaned forward, unashamed, trying to hear. The\n" +
            "murmur trembled on the verge of coherence, sank down, mounted\n" +
            "excitedly, and then ceased altogether.\n" +
            "\n" +
            "\"This Mr. Gatsby you spoke of is my neighbor----\" I said.\n" +
            "\n" +
            "\"Don't talk. I want to hear what happens.\"\n" +
            "\n" +
            "\"Is something happening?\" I inquired innocently.\n" +
            "\n" +
            "\"You mean to say you don't know?\" said Miss Baker, honestly surprised.\n" +
            "\"I thought everybody knew.\"\n" +
            "\n" +
            "\"I don't.\"\n" +
            "\n" +
            "\"Why----\" she said hesitantly, \"Tom's got some woman in New York.\"\n" +
            "\n" +
            "\"Got some woman?\" I repeated blankly.\n" +
            "\n" +
            "Miss Baker nodded.\n" +
            "\n" +
            "\"She might have the decency not to telephone him at dinner-time. Don't\n" +
            "you think?\"\n" +
            "\n" +
            "Almost before I had grasped her meaning there was the flutter of\n" +
            "a dress and the crunch of leather boots and Tom and Daisy were back\n" +
            "at the table.\n" +
            "\n" +
            "\"It couldn't be helped!\" cried Daisy with tense gayety.\n" +
            "\n" +
            "She sat down, glanced searchingly at Miss Baker and then at me and\n" +
            "continued: \"I looked outdoors for a minute and it's very romantic\n" +
            "outdoors. There's a bird on the lawn that I think must be a nightingale\n" +
            "come over on the Cunard or White Star Line. He's singing away----\" her\n" +
            "voice sang \"----It's romantic, isn't it, Tom?\"\n" +
            "\n" +
            "\"Very romantic,\" he said, and then miserably to me: \"If it's light enough\n" +
            "after dinner I want to take you down to the stables.\"\n" +
            "\n" +
            "The telephone rang inside, startlingly, and as Daisy shook her\n" +
            "head decisively at Tom the subject of the stables, in fact all\n" +
            "subjects, vanished into air. Among the broken fragments of the\n" +
            "last five minutes at table I remember the candles being lit again,\n" +
            "pointlessly, and I was conscious of wanting to look squarely at every\n" +
            "one and yet to avoid all eyes. I couldn't guess what Daisy and Tom\n" +
            "were thinking but I doubt if even Miss Baker who seemed to have\n" +
            "mastered a certain hardy skepticism was able utterly to put this fifth\n" +
            "guest's shrill metallic urgency out of mind. To a certain temperament\n" +
            "the situation might have seemed intriguing--my own instinct was to\n" +
            "telephone immediately for the police.\n" +
            "\n" +
            "The horses, needless to say, were not mentioned again. Tom and Miss\n" +
            "Baker, with several feet of twilight between them strolled back into\n" +
            "the library, as if to a vigil beside a perfectly tangible body, while\n" +
            "trying to look pleasantly interested and a little deaf I followed\n" +
            "Daisy around a chain of connecting verandas to the porch in front. In\n" +
            "its deep gloom we sat down side by side on a wicker settee.\n" +
            "\n" +
            "Daisy took her face in her hands, as if feeling its lovely shape, and\n" +
            "her eyes moved gradually out into the velvet dusk. I saw that turbulent\n" +
            "emotions possessed her, so I asked what I thought would be some\n" +
            "sedative questions about her little girl.\n" +
            "\n" +
            "\"We don't know each other very well, Nick,\" she said suddenly.\n" +
            "\"Even if we are cousins. You didn't come to my wedding.\"\n" +
            "\n" +
            "\"I wasn't back from the war.\"\n" +
            "\n" +
            "\"That's true.\" She hesitated. \"Well, I've had a very bad time, Nick,\n" +
            "and I'm pretty cynical about everything.\"\n" +
            "\n" +
            "Evidently she had reason to be. I waited but she didn't say any more,\n" +
            "and after a moment I returned rather feebly to the subject of her\n" +
            "daughter.\n" +
            "\n" +
            "\"I suppose she talks, and--eats, and everything.\"\n" +
            "\n" +
            "\"Oh, yes.\" She looked at me absently. \"Listen, Nick; let me tell you what\n" +
            "I said when she was born. Would you like to hear?\"\n" +
            "\n" +
            "\"Very much.\"\n" +
            "\n" +
            "\"It'll show you how I've gotten to feel about--things. Well, she was less\n" +
            "than an hour old and Tom was God knows where. I woke up out of the ether\n" +
            "with an utterly abandoned feeling and asked the nurse right away if it\n" +
            "was a boy or a girl. She told me it was a girl, and so I turned my head\n" +
            "away and wept. 'All right,' I said, 'I'm glad it's a girl. And I hope\n" +
            "she'll be a fool--that's the best thing a girl can be in this world,\n" +
            "a beautiful little fool.\"\n" +
            "\n" +
            "\"You see I think everything's terrible anyhow,\" she went on in a\n" +
            "convinced way. \"Everybody thinks so--the most advanced people. And I KNOW.\n" +
            "I've been everywhere and seen everything and done everything.\"\n" +
            "Her eyes flashed around her in a defiant way, rather like Tom's, and she\n" +
            "laughed with thrilling scorn. \"Sophisticated--God, I'm sophisticated!\"\n" +
            "\n" +
            "The instant her voice broke off, ceasing to compel my attention,\n" +
            "my belief, I felt the basic insincerity of what she had said.\n" +
            "It made me uneasy, as though the whole evening had been a trick\n" +
            "of some sort to exact a contributory emotion from me. I waited,\n" +
            "and sure enough, in a moment she looked at me with an absolute smirk\n" +
            "on her lovely face as if she had asserted her membership in a rather\n" +
            "distinguished secret society to which she and Tom belonged.\n" +
            "\n" +
            "\n" +
            "Inside, the crimson room bloomed with light. Tom and Miss Baker\n" +
            "sat at either end of the long couch and she read aloud to him from\n" +
            "the \"Saturday Evening Post\"--the words, murmurous and\n" +
            "uninflected, running together in a soothing tune. The lamp-light,\n" +
            "bright on his boots and dull on the autumn-leaf yellow of her hair,\n" +
            "glinted along the paper as she turned a page with a flutter of slender\n" +
            "muscles in her arms.\n" +
            "\n" +
            "When we came in she held us silent for a moment with a lifted hand.\n" +
            "\n" +
            "\"To be continued,\" she said, tossing the magazine on the table, \"in our\n" +
            "very next issue.\"\n" +
            "\n" +
            "Her body asserted itself with a restless movement of her knee, and she\n" +
            "stood up.\n" +
            "\n" +
            "\"Ten o'clock,\" she remarked, apparently finding the time on the\n" +
            "ceiling. \"Time for this good girl to go to bed.\"\n" +
            "\n" +
            "\"Jordan's going to play in the tournament tomorrow,\" explained Daisy,\n" +
            "\"over at Westchester.\"\n" +
            "\n" +
            "\"Oh,--you're JORdan Baker.\"\n" +
            "\n" +
            "I knew now why her face was familiar--its pleasing contemptuous\n" +
            "expression had looked out at me from many rotogravure pictures of\n" +
            "the sporting life at Asheville and Hot Springs and Palm Beach. I\n" +
            "had heard some story of her too, a critical, unpleasant story,\n" +
            "but what it was I had forgotten long ago.\n" +
            "\n" +
            "\"Good night,\" she said softly. \"Wake me at eight, won't you.\"\n" +
            "\n" +
            "\"If you'll get up.\"\n" +
            "\n" +
            "\"I will. Good night, Mr. Carraway. See you anon.\"\n" +
            "\n" +
            "\"Of course you will,\" confirmed Daisy. \"In fact I think I'll arrange\n" +
            "a marriage. Come over often, Nick, and I'll sort of--oh--fling you\n" +
            "together. You know--lock you up accidentally in linen closets and push\n" +
            "you out to sea in a boat, and all that sort of thing----\"\n" +
            "\n" +
            "\"Good night,\" called Miss Baker from the stairs. \"I haven't heard a word.\"\n" +
            "\n" +
            "\"She's a nice girl,\" said Tom after a moment. \"They oughtn't to let her\n" +
            "run around the country this way.\"\n" +
            "\n" +
            "\"Who oughtn't to?\" inquired Daisy coldly.\n" +
            "\n" +
            "\"Her family.\"\n" +
            "\n" +
            "\"Her family is one aunt about a thousand years old. Besides, Nick's\n" +
            "going to look after her, aren't you, Nick? She's going to spend lots of\n" +
            "week-ends out here this summer. I think the home influence will be very\n" +
            "good for her.\"\n" +
            "\n" +
            "Daisy and Tom looked at each other for a moment in silence.\n" +
            "\n" +
            "\"Is she from New York?\" I asked quickly.\n" +
            "\n" +
            "\"From Louisville. Our white girlhood was passed together there. Our\n" +
            "beautiful white----\"\n" +
            "\n" +
            "\"Did you give Nick a little heart to heart talk on the veranda?\"\n" +
            "demanded Tom suddenly.\n" +
            "\n" +
            "\"Did I?\" She looked at me. \"I can't seem to remember, but I think\n" +
            "we talked about the Nordic race. Yes, I'm sure we did. It sort of\n" +
            "crept up on us and first thing you know----\"\n" +
            "\n" +
            "\"Don't believe everything you hear, Nick,\" he advised me.\n" +
            "\n" +
            "I said lightly that I had heard nothing at all, and a few minutes later\n" +
            "I got up to go home. They came to the door with me and stood side by\n" +
            "side in a cheerful square of light. As I started my motor Daisy\n" +
            "peremptorily called \"Wait!\n" +
            "\n" +
            "\"I forgot to ask you something, and it's important. We heard you were\n" +
            "engaged to a girl out West.\"\n" +
            "\n" +
            "\"That's right,\" corroborated Tom kindly. \"We heard that you were\n" +
            "engaged.\"\n" +
            "\n" +
            "\"It's libel. I'm too poor.\"\n" +
            "\n" +
            "\"But we heard it,\" insisted Daisy, surprising me by opening up again in\n" +
            "a flower-like way. \"We heard it from three people so it must be true.\"\n" +
            "\n" +
            "Of course I knew what they were referring to, but I wasn't even vaguely\n" +
            "engaged. The fact that gossip had published the banns was one of the\n" +
            "reasons I had come east. You can't stop going with an old friend on\n" +
            "account of rumors and on the other hand I had no intention of being\n" +
            "rumored into marriage.\n" +
            "\n" +
            "Their interest rather touched me and made them less remotely\n" +
            "rich--nevertheless, I was confused and a little disgusted as I drove\n" +
            "away. It seemed to me that the thing for Daisy to do was to rush out of\n" +
            "the house, child in arms--but apparently there were no such intentions\n" +
            "in her head. As for Tom, the fact that he \"had some woman in New York\"\n" +
            "was really less surprising than that he had been depressed by a book.\n" +
            "Something was making him nibble at the edge of stale ideas as if his\n" +
            "sturdy physical egotism no longer nourished his peremptory heart.\n" +
            "\n" +
            "Already it was deep summer on roadhouse roofs and in front of wayside\n" +
            "garages, where new red gas-pumps sat out in pools of light, and when I\n" +
            "reached my estate at West Egg I ran the car under its shed and sat for\n" +
            "a while on an abandoned grass roller in the yard. The wind had blown\n" +
            "off, leaving a loud bright night with wings beating in the trees and\n" +
            "a persistent organ sound as the full bellows of the earth blew the\n" +
            "frogs full of life. The silhouette of a moving cat wavered across the\n" +
            "moonlight and turning my head to watch it I saw that I was not\n" +
            "alone--fifty feet away a figure had emerged from the shadow of my\n" +
            "neighbor's mansion and was standing with his hands in his pockets\n" +
            "regarding the silver pepper of the stars. Something in his leisurely\n" +
            "movements and the secure position of his feet upon the lawn suggested\n" +
            "that it was Mr. Gatsby himself, come out to determine what share was\n" +
            "his of our local heavens.\n" +
            "\n" +
            "I decided to call to him. Miss Baker had mentioned him at dinner, and\n" +
            "that would do for an introduction. But I didn't call to him for he gave\n" +
            "a sudden intimation that he was content to be alone--he stretched out his\n" +
            "arms toward the dark water in a curious way, and far as I was from him\n" +
            "I could have sworn he was trembling. Involuntarily I glanced seaward--and\n" +
            "distinguished nothing except a single green light, minute and far away,\n" +
            "that might have been the end of a dock. When I looked once more for Gatsby\n" +
            "he had vanished, and I was alone again in the unquiet darkness.";
    private String pattern1 = "darkness";

    private String text2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaa";
    private String pattern2 = "aaaaaabaaaaa";

    private String text3 = "bbbbbbabbababaaababbaabaaaabbbbbabbaabbabbbabbabbbbbbbaaababbaabaabaabbbabababbabbabbbbaaaababaababbbbbbbabaaababbbaabbbbbbaaaababbbababaaabaaaabbbbbabaaaaabbbaaabaabbbbbabaaaabbabaababbbbbaabbabbababbaababaaaabbbbaabababbbbbaabbaabaaaaabbbbababbbabbbaabaaaaabbaaaabbbbbbaabaaabbbbbbabababbaaaabbaabababaaaababbaaaabaabbbaaaaabbabbbbbaaaababaabbbaaaaaababaaababbbbbbaaaababbbabbbabaababbbbbabaaabbababababaaaaabbbaababaabbabbaaaaaabbabbbaabbaaababbbbabbabaabaaabbabbabbaaabaaababbababbbbbbbaaaaaaababaaaabaaabbababbbabbaaaaaaaaabaabaabbababaaabbabbbbabaaabaaabbabaabbbbaaaaaababaaaababaaababaaabaaabbbbabbaaaababbaabbabbbaaabbaabbaabaaabbabaabaabbabbabaabaaaaaaabbabbbaaaaaaaabbaabaababbbaabbabbbbbaabbbababbaabaabbabbabbabbababbaabbaaaaaabbbaaabbaaababaabbaaabbabbbbbaaabbbbbbbbbaaaaabbaaabaaaaaaabbabbabaaababbaabaabaaababbbaabbabbaaabbaaabbababaaaaabababaaaaabbbbbbabaaababbbabababbbabbbbbaaababaaabbbabbbababbababbbbaaabababbbabbababbabaaabbbaaababbbaaabaababbbaabbababaabaabbbababbbabaaaabababaaabbaaaaabaabbaabaabbbbabbaababababbaaaaabbabaaabbabbbabbabbabbaaaabaabbaaaaaabbababaabbaaababaaaababaaababbbbaaaabababbbaaabbaaabaababbbabaaaababaababbbbabbbbabaaaabbbaaabbbbabbbababababbbabaaabaababaaaabaabbaaabaabbaabbbbbbabbbabbaaaababbabaaabbbbaababaababbbbbaaabbbabbbbbabaabbabbbaababbbabaabbaabbbabbabbaaabaaaabaabaabbbabbaabaaabbbaabbaabbaababbaababbbaaaaabababbabbbaaaaaaaaabaaabbaabbbbbaabbaaabbaaaabbbbabbaaabbbaaabaababaaaaabbabaaaabbbabbabbbaababbbabbababbaababaabbabaabbbabbaaabbabaababababababbaaababbbbbababaaabaabaaababbabaaaabaabaaaabaabbbbbaababbbbbbbaabbaabaaaaaabbababbbbbaaaaabaaabbbabbbaaaaaaabbabbababbbabababbaabababbaaaaabbbbbaabbabbbabaabbbbbbbabaabbbbbbbbbbaabbaabbbbabbaaaaaaabaaababbaaabababbbabababaaabbabbbaaabbaaaabbbaababaaabaabbbaaaababbaababbaaababbaaaabaaababababbbbbbabbbbbaaaababababbabaabaabbabbbabbbbbaabbbabbababbaabaaaabbbabbaaabababbabbaabbbabbbaabababbabaabaaaababbbababbaaaaaababbbaabbbbbababbbbaabbaaaabaabbbabbbbabbbaaaaabaaaaabbbbbbabababaaaaaaaabbababbabbaaaabbbbbbbbaaabbbbabbaaaabbbabbbbbbaaabbbaabaaabaaaaabaabbbbbaabaaaaababbbbabbbaabaaabbbaaaaaabbaabbbbbbaaaabbaabbbbaaabbbbbababaabababbbaaabbbaaaabaabaabbaaaabbbbbaaaabbbbabbaabbbababaababababbababbaabaaabbbaaabbbabaaaaabbaaaaababbaaaabbabaaaabbbaaababbabbabbbabbaababaaaabaaabbababbbbbaabbabbabbbbababbaaaaaaaaaabbbaaaababaabbbaabababaaaababaabababababbaaabaabaaaaaaaabbaabaaabaaaaababbaabaabbbaababaababaabaabaaaabbbaaaabbabaabaaabbaaaaababaabbabbbababbbbbbabbaaabaaabaaaaaaaabbabaababaaabbbaaabbabbbbabaabababbaaaaaaaaaaaaaaaabaabaabbabaababaaabaababbabbabaaabbbbbbbbababababbbabababababaabaabbbbaaaaabaaabbbbaabbbbbbaaabbbababbbbaaaabaabbbabbbabaaabbaaabbaababababbabaaaaaaaaaaabbabbabababbababbababbbaaabbbbbabaabaaabbbaaabbababbabaababababbbababbbaaabbaabaababaabbaaabbbaaaaabbbaaaaabaaababbbaabbbbabbababbbbaaaabbabbababbbbabbbbbbaabbaabbaabbabababaababaaaaabaaaaabababbabbbbabbbbaaabbbaabbaaaababbababaabaababaaabbbabbaaaaaabaabaaabbaaaabaabbbabaabbaabbbbbabaababbbaaabbaaabbabbaabaaaabbababbbbbabbbbaabbbbbbabaabbbabaaaaabbbababbbbabbbaabaaaabbabbbaaababbbbbaaaabbaaaaabababaaaabbaabaabaaaaaaaababbbbabbbaabbbbbbbbbbbbabaaabaaaabbaabbabbaabbabaaabaabbabbbbbababaabbaabaaaaaaaabbbbbabaabababaaaaabbbbaabbaabbaababaaabbabaaabaabaababbaaaaaaabbaaabababbabbbaaaaababbbaabbaabaaababbabbaaaabbabbaabbbaaabbabbaabbaaaaabbbabbbababababbaababbbabbbaaaabababbbaaabaaabbbbaaabbabbabababbbaabbbbabbabaababbbbabababbaababaaaababbbbbabbaabbbaababbaaabaaabbaabbbabbbaabbabbabbbbaaaabbabbbaabbbbaababbabbbabaabaaaaabaaaaaaaaaabababababaaabbaabbaabbbbaaabaaababbbbbaabbbbabbbbbabbbbaaaaabababbaabbaaabaaabbabaababaaababbbbaabaaabaaabbaababbabababaaaaabaaaabbaabbaababbbbbbaaaabaabbaabaabbaaaaaabbaaaaabaabaabbabbbababaabbbaaabbbbbaaabaabbbaaaaaaabbaabaaabaababaaabbaaaaabbabaabbabbaabbbababababaabbaaaaaabbabbaabbbbbbbbbbbaaaabbbaabaaabbbbbababbbabbbbabbaaabaababaaaabbaabaabbbbaaabbababaabbbbaabbabbbbaabbaabbaaababbbbbabaabababaabababbbbabbaabbbaabbbbbbbbabbbabaabbaaaaabbbaaaabbbbbabbabaaaabbaabaaaaaaaabbabaaaaaabababbaabbbbaaabbbabaaaabbabbbaababababbbaaabaaabbbbbaabbbbabababbaaababbaaaabbaabaabbaabbbabbbbabababbbababaaabbaaababbaabbaabaabaaabbbbabaaaaaaaababbaaabaaabaaaaabababaaaaaabbabbaaabaabababaaababaabaabbabaababbababbbaaaaaabababbbaabbbaaabbabababbabbbbbbbabbbaaaabaaaabaabaaaabbbabbabbabbbbbbbbbaaabbbbaabbabbaabbbbaaabbbbaababbabbbbaaabbbbbbabbbbbbaaaababaabababbbaababaabbabbbaaaaabbbaaaaaabbabbabaaabbbaababbababaaababbbabaabaabbababaaabbbabaabbaababbababbaabaabaabbbabaabababbaaaabababbabbbbaabbaaabbbbabaaaabbbbaabbbaababbabbbaaaaabaaabbbbbaaaaabbbbbaaaabbbababbbabbabababaaabbaaaabbbaaaaaabbbbbaabaabaaaaabababaabbbbabbbaabbababababbababbbabaaaaabaaaabaaaaaabbbbbabbbbabbbaabaaaaabaaabbaaaaabbaaaaabbbbaababaababbbaaabababaaababaabaaaabbbaabaaabbaabababbbbaaaababaabbbaaaabbbbabaaaaabbaaabaabaabbbabbbbababaaabaababaababbbbabbaabbbbaaaaababbaaabababababbbbbbbaabbbbaabaabaabbaabbbaababaabbaaaaaaabbbbaabbaabaaababbabababbababbbabbaabaabbbbbaabbaaaaaabbbababaaabaabaaaabbaaaabbbbaababbbbbaababbaaabbaaabaabaabbbbbbbbaabababaaababaaabbaabaabbbabbaabbaaabaaaaaabbababbaaabbbbbababababbbababbabbbbbbaabbabaabaaabbaabababbbabaaababaabaabaaaabbaaabbbbbabbbaabaaaabbabaaabaaabbaaaaababababaabaabbaabbbabbbaabbbaaabbaaaaaabbaabaabbabaababbbaaababbbbbbaababbbaaababaabaabbbbbbbaaaabaaaabaababbbbabbababaababbbbaabbaaaaaabbabbbaaabbbaabaabbbaaabbbbbbaaabaababbabbbaabaabbbabbbabaaaaababaaabbbabbbbabbabbaaaabbbbababbbbaabaaaababaaaaababbaabaaabbaaaabaaaabbabababaaaabbabbaababaababbababbabbabababbbaaabaaabbbbabbbbbaaabbbaababbabbbababbbbbbabaabbaabbbbbaabbbbbababaaaabbbaababaabaaabababaaaaabaaaaaabbaaaabbbaaaabababbaabbaaabbaaaaaaaaabbbaabbbaaabbbaabaababababaaaabbbbababaaaaaaababbabaababaababaabbbaaaaaabaaaaaabbabababaaabbaabbaabbaaabbbbabbababababaabaaaababaaaabaabbabbbabbbbabaabaabbaabbaababaabaabbabababbaaabbbaaaaabaaaabbbabbbaabababaaaaabbbbbbbabbbbaaaabaaabbaabbaabbaabbbababbbbabbbbbabbabaaababbbabbaabbaaaaabbababbaaabaaabaaabaababaaabaaaabbaaabbbaabaabbbbababbbaabbaabbabbbaabaaaaaaabaabbbaaaaabbabbbbaabaaabaaaaaabbbbaabbbbbbaaabbbbbabbbaabababababaabbababaaabababbaabaaaaaaaabaaabaabbabbabbbbabbbabbbabaabbbbbbbbaaaaaaaaababbabaaaaabbabbbabbbbbababbaaabbaabaababbbbabbabbaabbabbabababbabaabbabbbaababbabababaababbabbaababaaaabababababbabbaaaababbbabbbbaaabaababbbbbbaabbbbaabaabaabbbabaababbbbaababaaaabbaabaaabbabbbaabaabbbbaabbbabbbbaabaabbabaabaaaaaabbbabaaaaabbaababbbbaaaabababaaaabaabbbaabaaaabababbabbbbbabaabaabbbbbaabbaaaabbbabbbbbaaaabbbbbabaaaabbaababbbabaaababaababbaaaaaaabaabbaababbbbbbbbbababbaaaaaaaaabaaababaabbbabaaabababaaaabbbbbaababaabaabbaaaaabbabbbababaababaabbbabbbaaaaaabbabbbbabbbaaaabaabbaabaaabaababbbbbaaababbaababbbabaabbbaaaaaaaabbbbaabbbababaaabbabbbbbbbabababaabbbabaababbbbabbabbaababbaabbbaabbbaaabbaabaabaababbbabbbaabaaababbbaaabbbbbababbbbbabbbaaabbaaaabbabaaaaaababaabbbbbaaababbabbabbabaaaabbbbbababbbabaabbbaaabbbbaaabbbbbabaababbbaabbabaaababbbbabaabababbabaaabaababbabbbabababbabaabaaaaaabbbbbababbbbbbbbaaaaabababababababbabaabbaabaaaababbaabbaaababbaaaaabbaaabaabbaabbbaabbbabbababaabaabbaabbaabbbababababbbbbbbabaabababaaaabababaaaabababaaaaabaabbaaabaababbbbbaaabbaabaaaaabaaaaabaaaaaabaabbbbabaaaabaaaabaaabbbaabbaabbbbababbabaaabbbbbabaabaababababaaaabbaaaaabbbbbbbbbaaaabaaababaababbabaabbbabbbbbbaabbbabbabbbbbbbabbabbaabbabbbaabbaabaabaababbaaaabbbbbabbbbbbaaabaaaaaabbbaabaabbbbabbaababbbbbabaaabbabababbababbababbaaaababbbbabbaabaabbababbbbabbaaababbbabaaabbbaabbabbaabbbbabaaaaaaaaaaaabaabaaabbabbababaaabbbabbbabbbbbaaaabababbbababbbbbbabbababbbabaabbaaaabbaaaababbbbbbbbaaaaababbbaaaabababbaaaabaaaaaaaaaababaaabbbbbaaabababbbabbaaaaaababaaaaaababbbbaabbabbbbaababbbaabbbabababaababaabaaababaaabbbabbbabbabbabbabbabaaabababaaababbbbbabbabaababaababbbbbabaabaababbaabaaabaaaabbaaaabababbabaabbaabaababbaaaabbababbbbbaaabbbabbaaabbabaaabbbabaabbbababbbbbbbbbbbbbbababbbaabbbbaaaaaabaabbbbabaaabaaaaaaabbababaaabbaaabbbbbaabbabaababbaaaaaabbabbbbbbabaababbbaaabbaabaababbbbabbbbbaabbaabbbbbababaabaaababbbbbaabbabaaaaaabbbabaabbbbabbbaaababbbbbbbbaababaaabbbaaababbbbabbbabbaaaaaabbabaabaaaaabbabbaabbaaaabababaabbabbbbbabaaaaabbbaaabaaabbaaaaaaaaaaaaaaaaabaabaaaabbabbbababababababbaabaabbbabaaabbbbbaaaaabbbaabaaababababaababbbbabbbaabbaaabbabaaabaaabbbbbaabbaabbaabaaabbaabaaababbbabaabbbbbbbababbaaaaaaabaaababbaabbabbaaaabbbababaabababbbaabbaaabbabaaaabbabbbabaaababbabababbbabbbbbbaaababbbbaababababbbaabbbbbbbbbbbaaababbabababbababbbaaaaaabbbaabbbaaaababaaaaaaaabbbbabaabaabbaaaabbaaaaaabbabbabaaaaabbabbaababbabababaaaabaabbbababaaaaabbbbabbbababaaabbbbbaaabaabbbbababbabbbbabbabbaaabbbabbbabbabbbababababbbbbbbaababbaaaabbaaabaabaababaaabbbbabaabababbbbabaaabaabbabaaaaabaaabbbababbaabbbbbbbbaabbbabaaabbbbbbbaababaaaababbbababbabaaabbaabbabbaababbbabaabaaabaababbbabaaaaaaababbbbaaabaaaabaabbaababbaababaabaaaaaabaaaabbbbaabbbbbaaabaaaababbababaabbbbbaabbbaabbabbbbbbaabbbabbbaabbbabbbbbbbabbbaaaaababbbabbbbabbbbbabbaaababaaaabaaaaaaabaababbbababaaaabbabbbbbabaabbbaaaaabaaabbbbabbbbabbbbbbaaabbbababbababbbaababbbabbbaaabbaaabbbbbabbbaaabbbbbabbaaabaabbabbbbbaabaabaaabbaabaaaababbababaaabaababbabbaaaaaaaababaabaaabbbbbbbabaabbabbaaaaaababbabbbaabaaaababaabbbbaabbbaaaaaabaabbaabbaaabaabbbabbbababaabaabbbbababababbbbbaabbbbbbbaabaabbbbbbbaaaaabbbaaaababaabbaabaaaaababbabaabaabbbbbbaaabbaabbbbaaabbbaabaaaaaaaaaabbbbabbaaababbaabbbaabbaabbabaabaaaaaabaaaabaabaabbaaabbabbbaaaabbbbaabbabbaabaabbaaaabaaaaaaabbaaabaabaabaaaaaababbababbbbbaaaababbaabababbaababababaababbabaabbaabbaaaaabababababababbababbaabbabaababbbbbbababaaababaaaabbbbbabaaabbabbbbaabbaaabbbaabaaabaabaabbbbaaabbaaababbbbbbbbbbababaababbaaaabbaabaaaaababababbababbaabbaabbbaabaaabaaabaaabaabbaababbababbaababaabaaabaaabaaaaabbababaabaaabbbbbabaabbaabbbaaabbbbaababababbabaabbabaaabbabababaabaaabbbbbbbaaaababbabbaabbbbbbababbbbaabbbbabbbbaabbbbbbaabbbaababaabababbaabbaababbbabaabbbabbbaabaabbbbaabaabaabaaabbaaaaaaababbbbbbbbaabbabaaaaaababaaabbabaabaabbaaaaabaababaaabaaaaaabbbaaabaaababaabaabbababbabaaaaaabbbbaaababbbabbbaabbbbaaababbabbbbbaabaabbaabbaabaabababbaaabbaababaaaaaabbbabaaaabbbbbbaaababababaabbbaaaaabaaabaaababbabaabbbaabbbabbbbaaaabaaabbbabbbbbaabaaaaababbbbbbbabaaabbabbbaaaabaaaababaaabbababbbabaabaabababbbbbaaaaabbabaababbbaabbaabbbbbbbbaaaabbbaabbaabbababbbbbbaabbbbbaabaaabaabaaaabaabbbabaaababbbaaaabaabbbabbbaaabbbbbbbabaabbbaabbbaaaabbaabbbbbbbaababbbbabbbabbbbaababaaabaabbabaaaaaababbaabaaaabaaaababaaaaaaaabababbabbabbabbbbabaaaaababaaabbaabbaababbbabaabbabbbaaabaabaaaababbbababbabababbbabbbbababaabaaaabbbababbbbbbbabbbaaaabbbabaaababbbbaaaababbbababbbabababbbaaaaaabbaaaabababbbbaaababbabbabbaaaaaabbbbbbaaabbaaabbabaabbabbababbaabbabbaabbabbaaaabaababbaaabbabbabbbbbabbbbababbaaaaabaaabbbbbbbbaaaaaaabbababbbbabaabbabbbbaabbaababbaaaabbaaabbaaabbaaaabababaabaaabababbaabbbbbbabbaabbbabbaaabaababbaaaabbbbabbbbabaabbbabbaaabbbaabbbbbabbbbbababaabaaabbabbbaabbaaaaaabbbbababaabbbbaababababbaaaaaaaabaabbababababaaabbaaaaaaabbabbaaabaabaabbabbaabbbbaaaaaaabaabbbbbaabbabaabbbaaaabbaabbabaabbabaaababababababaabaaaabbaabbabbabbbaaababaabbbabababbbaababbbbabbbbbbaaabbbabababbbbbaaabbabaaabbbbbababaaaabaababbbabaabababbabaaaaaabbbabbababbababababaaaababbbabaabbbbbbbbaabbbbbbababababbbabbbbbbabbbababbbbbbbaaaabbaabbbbabbbaaababaaabbababbabbabbaabaaabaaabbababaabaaababbaabaaaabaabbaaaaaababbbbbabbbbbbabaaaabaababbbbaabbabbaaabbabbababaaaababbbabbaabbbaaabbbbbbababbbbaababababaaaabbabbaaaaaabbbbbbbbbaaabbbbbbbbbabbbabaabababbbbabaabbbabbbaaabbabbabaabaabaaaaaabbbabaaaaaababaaaaabaabbbabbabbaabbbbbaaabbbbabbbabbabbbbbbbbabaabababaaaabbabbaababaabbabbaaaaababbabbbaaaabbbbbbbbaabaabaaabbababbaabaaaaabbaabaaabbbaababbaaaaaaabbbbbbaabbabbabaaaabbaababbabbaaabbaababaabaaababaaaaabbaabababaabaaaaaaaaabbbbbaaaabaababbbbbbbbabaaabbabbabbbaaabbaababbbbbabbbabbaabbbababbaaabbabbbbabababbbababbaaaaabaaababbbababbabbaaabbbabbbbbabaaabbbaabababaabbbaabaaaaaaaabababbbbbabaaabbbabaabbababbaaaaababababababbaababaabbbbaabbaaaaababbaaabbbababbaabaaaabbbbabbaabaaaabaaaaabaaaabbaababbbaabbaabbbaaaabbbbbbbbbabbabbabaababaaaaaaabbbaabaabbbbbbababbbbbbabbbaaaabbaaabbaabbbbaabbaabbaabbabbabbaabababaabbaaaaaaabaaababbbabbbbbaaabbabbaabbaabababbaaabababbbaabaabaabbbbbaabaabaaabbaaaaabaabbbababbaaaabaabbabaabbababbbbbbaababbbababbaabbbababbbbaabbabbbbbbabbbabbbaaaaabaabbbbabaabaabbbaaaaaababbbbbaaababbaabaabaabaabbaabaaaaababbbaababbaaabbabbaabaaabbabbbbaaaababaaaabaababbababbaabbbabababaaabbbabbbababaaaaabaabbababbbababbbaabbabaababbbbabaabbabaababaababbbabbabaaabbabbbbaabaababbabbaaabaabbbbaaababbaaaaabbbbbaaaaabababbbbbbbbabbaaaabababaaabaaabbbabbabbbbaabbbabaaaaabbababbaaaaabbabbaabbbbaaaabbbbbbbaabaaaabbaaaababaabbbaaabababaaaaabbbaaaabaaaaabaabaaaababbabbaabbabbbbaaabbbbabaabaaababaababaaabbbbabbaabbababbbaaaabaaaaaaabaabbbaabbbbaaabbbabbabbabbababbbaaaaaaaababaaaaaabbabaaabbbabaaabaaaabaabbaaabbabbbbbaabbabbabbaaaaaaabbabaababbbbbbababaabaaaaabbbaaaabaaaaaabaababaabaaabbaabbaababbbaabbaababaaabbabbabbbbbaababbbbbaababbaababbabaabbbbbbbaaabaababbbaaaaabbbbbbaaabaababbabaaabbbbaaabbabaaaaabaabbbbaabbbaabbaababbabbabbabbaaaaabbbabbbbabbabbabbbbabababbabaabababbbababbabababbabaaaabaabbababaabbbbbbbaaaabbbbbabbbaabbabbaaaabbabbbbabbbbabaabbaabbaabbbaaaaababababaabbbbbbbbaaaaaaabaababbbabaaaabaababbaaaabbababaaabbabaaaaaaaaaaababbaabbabbbbbabababbbaaaabbbbbaaabbbbabaaabbaabbbbbaabbabbbababbabaaaabaaabbbabbabbaaabbbabbaaababbbbbbbbbaabbbbaaabbbaaabbaababaabaaaaabbabaabbbaaaabababbbabbbaaaaaababbbabbabbaaaaaabbabbbbbaaaaabaabaababaaababbbbaabababbbbabaabaabbbbbbabaabbbbabbabbbbaabaaabbbaaaabaaabbbbaababaababbabbaaaababaabaabbbaabaaabbabababababbaaababaabbababbaababababababbaaaaabbbbbbbaabbbbaabababbbaabbbaaaabaaabbbbaaabbbbaabaaaabbabbbbaababbbbabaaabbbabbaaaabbabbbbbbabaaaabbabaaaaaabbbbabbbbaabaabaabbaaabaaabbaabbabbbbaaabaaabaabaaaabaabbbaaaaaaabaabbbabbbbbbaabbbbabaaaaabaabbabaababbabbbabbbaaaabbbaaaaababbababaaabbababbbbbbbabaaaababaaaaaababbbabbababaabbbabaababbaabbabbbabbbbbabaaaaabaabaabbaabaabbaaabbbbbbaaabaababbaababbbababbbbbabababaababbbbabaabbbabbbbabbbbbbabbaaabaabbaabababaababbbbaabbaaabbaabbbaaaaaaabbbbbbaabaaabababbaaaabaaaaabbabbaaababbabbbbbbbabbbabbbaabbabaabbbbbbbaabbaabbaababbbbbabbababaaaaaababbbaabbabbababaabbabaaaababaaaaaababaaaabbabbaabbbaabbbbbbabbbbbbaaaaaababbabbbbabbaaaaaaabbbabaabbbaaababababaabbbbabaaaabbabaaaabaaabbbaaabbbbaababbaaabbabbbaabaaaaabbbbbabbbababbbabbbababaabbbabbabaaabbbbabaabbbbabbbaaaabbbaaabaaabbbaabababbbbabaaaabbababaaaaabaaaabbababbaaaaabaababbbbbaaaaababbbbbbbbaaaababaabaaaabbbaaababaaababaaaaaabbbbbbbabbbbbbbaaababbbbabbbabbbabaaabbbabaabababbbababaaabbbbbababbaaaaaabaaabbbaabbaaabbbababbabbaabbbaaabbbabababbbbaabbbbaabbbaabbbbbaaaaaaabbaaaababbbbbbbbbabbabbbbabbbababbaaaabababaabababbaabaaaaababbabbabbbabbaaaaabbabbbbaaaaaabaabaabbbaabbbbbbaabbbaabbbaaaabbabaabaaaaaaaababaaabbbbababaababbaaaaaaababaaaaaababaaaaabbaaababaabbaaaababbabbbabbabbbbbbbaaaaabbabbbaaabaaabbbabbaabaaaaaaabbbbbabababbbabababbbbbaaaaabbaaaababbaaaabbaaabaabbbbabababbbababababbaabaaaaaababaaaabbabaabababbabaaabbbbaabbbababbbbbabbababaaabaabaaaaaababbaabaaaaaaabbbaaabbaaaaaabaabaabaaabbaababbababbbaaabaaaaababaaaababaabbabbabaabaabbaaaaaababbbbbbababaabaabbaaaababababbbbbabaababbbabbaaabbbaaaabbbaabbabbbabaabaababaaaaabaaaababbaabababaaaababbbababababbaaababaabaaabbbbabbabbbbbbabababababaaababababaaaaaababbabbbabbaababababbabbaababbbbabbbbabbbbbbbbababbbbaabaabaabbbaaababaababaaabbbabbabaabbaaabbaaabaaababbbabbaaababaaaabbabaaabbaabbbabababbabababbbbaaabaaaabaaabaaaaabbbabbabababaababbbaabbbbabaaaabbabbaaabaaabbabaaaaaaaaaaaaaaabbabbaababaababbaabbabbbbaaaaaaaababbabbbbbbaaaabaaabaaaaabbabbabbaaabaabababaabaaaaaaaabaaabbabaaaabaabababbabaaaaaaabbbabaababababaababaaabbbaaababaaabbabbababbbaabbabbbabaabaaaaabaabbbbabbbaabbaabbbabbabaaabaababababababaabbbaaabaabbbbbbabbbababbbaabbababbbabbbabbbabaabbaaabbabbbbbbbbbabaabaaaabaaaabaaabbaabaababababaaababbbbaaaaabababaabbabbbbbaaabbabbaabbaabbbbabaaabbbbbbbbabbbbabaaaabbaaabaabaaaabababaaabbaaabbbabbaaabbabaaaaaaaaababbbabbaabbaaababaababbaabbaabbbbbbbaaaaaabbbbabaabbaaaabaabbaabaaaabbaabbbbabbabbabaaaabababaabbaaaaaaabbbbaaabbaaabbbbaaabbbbaaababbaabbbabbbaabbababbabaaaaaababaaababaabbaabbaabbaababaababababaaaaabaaaababbaaabababaabbabababbbaaaababaababbaaabbbaaaabbaaaaabaaaaaaabaaabaaaababbbaabaaabbbabbabbbbbbaaaaabbbbabbbbbbbababaabbbbabaaabbbbababbaaaababaababbaabaaabaaabbbbabbaababbbabbabbaaaababbaabbabbbbbbbbbbbbbabbabababbaababaabbbaaabaaaaabaabaabaaabbbbaabbbbbaaaaabaaabbababbabaaaabbababbbbaabaaaaaaababababaaaabaaaaaaabbbababbaaaabbabbbaabababbbabbbabaaabbbabaabaaabbbaaaabbaabbbbaaaabbabaabbbbbabbaabbbbababbaaaaaaaaababbaaabaabbaaaabbabbaabaaabbabababaabbbbbababbaabbbbabbabaaaaababbabaaaaaaabbbbbabbaaaabaabbaaaabbaaaaababbabaaabaaabababaababaabaaabaaabbaaabaaaabbbbaaaaababbaaabbabaaaaaaabbbbabbabbbaaabbbbbbbababbbabbabaababaabbaabababbbababbaabaabbabaabaaaaaaaaabbaababbbabbbbaabbbbbaababaaabababaaabbababaaaabbbabaaabbbbaabaabbabbbbbaaaaabbabaabbbaaabbaaabaaaaabbaabbaaaabbaaaaabbaabbbbababbabaaababaaaabbbabbbbbabbaaaabbaabbbabbaabbaaaaaaaaaabaaabbbbaabbaabbaabbbbbaabbbaaaabbabbaababbabaababbbbbababaababbababbbaaabaabbababaaababababbbabbabbbaabbbabaabaaaabababbbbaaaabbababbaabbaabbbbbababbaabaaabaabbbbbbbbaaaaaabbbbbbbaabaababbbbabbbabbabaabbabaaaaaaaaaaaababbbbababbabaaaababbababaaaaabbababaababaabbbbbbabbaaaababbbbabbbaaabaaaabbbabbaabaaabaaabaabbabaabbaabbabbabbabbbababbbbabbbbbaababbbabbbabaaaaaababaababaababbaaaabbbbbbbabababbaabaababbaabaabbabbbbaabbbbababbbbbbbabaabaaaaaabababaaabaababaabbababababaabaaabaaabaabbbbaaaaabaaaaabaababbaaaaaababbbababbababbbbabaaabbabbbbabbaabaaaaabbaaaaabbbabbabbbaaabaabbaabbaaabbaaabaaabaaababbabbabbbaaabaabaabbbaaaababbbbbbaabababbbabbabaabaaabbbaaabaaabbababaabbbabaaababaaabbaabbbaabbababbbbbababbbaabbbbbbabbbbabbbaaaaaaabaaabbbbbababbbabaaaaaaabaaabbababaaabbbbbabbbabaaabbabaabaabbbbaabababbabbbaabbbbaaabbaaaaaaaababbbaabaabbaaabbbbbabbaabbbbbabbaabbbbabbabbabbabaaabbbabaaaaaabaabbbbaababababbababaaaaaabaaaababbbbababbbabbbaaabababaabbaaababaaababbaaabbbbbbbbbbbabaaaabbababbbbabbaaaabbaabbabbbbbbbabbababaabbbabbbabaaaaaabbbabaabbbaaabbbabbbbbbbbbbbababaabbbbbaabaabaaababbaaaabbaabaabababaaaabaababaabaabababbaabbbabaabbbabbbbbbaaaabaaabbaaaabaaaabbbaabbbbaabbbbaaaaaabbbbbbbbbabbaabaaabbbaaabbaaabbaaababbaaaabbaabbabaabaaaaaaabbabbbbabbabaaaabbabaabbbbabbbabbaaaaabaabbaaababbaababbbbbaaababaaaabbabbbbbbbbbbaabbabaaabaaabaabbaaaababaabaaababbbbbababbbaababaabaaababaaaaaabbbbbaaabbabbbbbbabbbbbbbbababbbababababaababbaabbbabbaabbbabbbbababbabbbbbbbaabaaaaaaaababbaaabbaabaababbabbaabbabaaababbbbbaababbbbbbaababbaabbabbbabaaabbbbaaababbaabaaaabaaaaaaaaaaabaabbabbabbabbaaaababbabbaaababbbbbbbbbabaaaaaabaaaabbbaaabaaaababbbbabaaaaabaaaaababbabbaababababbbbbbbbbabbbbaaababbaaaabbbabbaabbabaabababaaabbabbbbbaabaaaabbabaabababababaaababababaababbbbbbbabbbaabababbbbbbbbbbbaabbaaabaaaababbbbaababbabbaabbbbabaaaabbbabbaabaabbbbbabaabbabbabbaaabbbbabaaaaabbabaaaaaabbbbbababbbbbaababaababbabaababbabbabaabbaabaaaabbabaabbbabbbbababbabaabaaabbaabaaabbababababbababbaaaabababbaabbbbaababbabaabbaabaaabbaabbaabbabaabbbaaabaabbaabbbaaabbbabbabbabbbabbbbbababaabaaabaabbbbbbaabbbabbbababbabaaabbbbbabbabbabaaabaaaabaabbaaabbaaaaaaaabababbabababbababaabbbababbbaababbbaabbbbabababaababbaababbbaabbabbaaabaaabaaaabaabbbaabbbabbbbaaabbaaaababbaaabbbaaababbbbaabaaaabbbbabbaaaaaabbbaaaabbaaabaaababbbabbbaaabbbabaabaabaabbaabbbaaaaaabbababaabaababbaaaaaaabababbbaaaababbabbaabbbbbbbbbabaaababbababaabbbbaababbabbabbaaabbbbbabaababbbaabaababaabbbaabaaababaababbaaaaabbbabbbbaabaaaababaabaabbbbbabaaabbbaabbbaababbbbaaabbabbaaaabbaaababbaaaabaababaaaaaaabbbaaabbbbbabaabbbabbaaabbaaaaababaabbbbbbabbaabaaaaaababbbbaaaababababbaabbbaabaabababbabbbbbbaaabbaabababbbabaabbbbabaabbbabbabaabbbbbbbbbbbbabaaaabababbabbbbbbaaaaaabaabbbabaabaaabaaabababbbabaaabababbbbbaabbbbaaaaabbaaababbbbbaabbababbaaabbabbabaababbaaabbabbbbabaabbbbaabbbabbbbbabaaaaaaaabaabbabbbbabaaaaaabbbabbabbbaabbbaaaaabaaabaababababaaabbbbbabaabababbababaabaabbbababaaabbabababbbbbaaaabbaaabaaaabbababaaabaaaaaaababbaaaabbaababbbbaabbbabaabaaabbbbaabbaaabaabbabaabbbbbabbbbaaaaaabbaaabbbaaabaabbabbbbbaababbbaaaababaabbbaabababbabbbabbbaabababbabbbbbababaabbaabbaabbabbbbabaabababbbbbbababbabbababaabbbaaaababaababbbaaabbbabbaabbbbbabaababbbbbbbaabbbbbabbabbabbaababbababababbabaabaabbaabbbbbbbabbbbaaaaaabbbbbbababaaabbaabbbbaabababaaababaababbabaaababbaabaabaababaabbbabbabababaabbbbbbababaaabaaabbbbabbbbabaaaabaabbbaabbaabbaaabbaabbaababbaaaaabaabaaaabbbaaaabbbaabaabbbbbabbababaabbaaabbabbbbbbbbabaabbaaabbbaaababaaaaaaabbabababbaaabbbbbabbbbababaaaaaabbabaaaabbaabbbabbaaaabbaabbbabaabbaaabbbaaaaaaaaabbbbbbaababbbaaaababbbaaabaaabaabbbbabaababababbababaabbaaaaabbbabbabbbbbabbaabaabbbbbbabababbbbbbbbbabaaaaabbbaaabbbaaabbbaabbaaaabbabbbbbabbbbbbaababaaabaaabbbbaabaaaaababbbbabbaabaabbbababaaabbbbaaabbbabaabbaabbbbaaaababbbbbaaaabbaabaaaaabbbbbabbaaabbaabaabaaaaaaaabbbaaabbaaaabbbbabbaabbababaaababbbbabaaabbbbbabababaababbbbabaaabbbbaaaabbababbbaabbaabaaababbaabaaabaababaaababaabbaababaaaaaaabaabbbbbbabbbbaaabbaabaabbabbaababababbbbbabbbaaabaabbabaabaaaabbbabbbbbbabbbbababbaabaaabaababaababaabbaaaabbbbbaababbaaaababaabaababbbbaaaabbbbbbbaabaaabaababbaababbaabaabaaaababbaabababaaabbabbbabbaababbbbaaaabaabaababbbbbaabbabbaaabbbaaabbbaaabbababbbbbbbbabbababaaabababbbbabbbababbbbabbabbbbbbbaabbbbbaaababbaaaabaaaabaabbaaaabbabbbaabbabbbaaabbbbbabaaaababaaababbbbbaabbbabbaaabbabbbabaabbbbbaabbbbabbbbbaaaabbaaaabaaaaaabbbaaabaabaabbbaabbbbbabbabaabaabbbaaabbbbaabbbbabbbbaabaabbbaaabbbaaabbbbbaabaabaabababbbaaabaababbbaabbabaabbaabbaabbbabbababbabababbbaabbbaabbaaaaabaababbbbbabaaaaaabbabbbababbbbbbbbbbabbabbabbbaaabaabbabaaaaaababababaaaabbbbaabbabbabababaabbaababbbabbbabbabbbababbbbbaababbbbbabbaabbbbbbabbbbababbbaaaaabababbababbababbaabbbbabaabaaabaaaaabaabababbbabbaaabaaaaabbbbabbabaaaabbabaaabaaabbabbabbabbaabbabbbabaaaaaabaaaaaabbaaabbabaabbbbabaabbbbbabaaabbbaabbbbbaabbbbbabababaaaababababbbaabaaaaabbaabbababbaaabaabaaabbabaabbaabaaaabaaabbbaabaabababbbbaaabaabbbbaababaababaaaabbbbabbbabababbaabbaaabbbbaaabbabbabbaaabaaabbbbaaababaabbbbbaaabaabbbabbabaaabaabaaabaabaabbbbabaabaabbbaabbbababbabbbbbaabababbabaabbabbbabaaaaababbbbaaaabbabaabbababbbbbbbbbbababaabbabababababbbaabbabaaaabababaabbbabbabababababaaababbaaaaaaaaaabbbabaaabababbbabbbababbabbaabbaabbbbabbabababbabbabaabaaabbbabbbbabbbaaaabbbabbababaaabbaabababbbababaabbabaabbbaabbabbaabbababbabbbaabaaaaabbbbabababbbaabababbbaababaaababbaaabababaaaaaabbaaabbbabbbabaabaababbabbbbbabbbbbaabababaaaaabbabbaaaababbaaaaaabbbaababaabbabbbabbaaaaaaaabbbbaaaaabbbbbabababbabaaabbabbabababbbaaabaaababbaabbbaabbbaaaaaaabbbbaabbaababbbbabaaaaabbababababbbbabaabbbbaaababbababaababbbbbbabaabaaaabaaaaaaabbaabaabaaaaaaabbaababbaabbbbbbbbabababbabaabbabbabbabbaababbbababbababaaaaaaaabbbbabbbabbbabbababbaabababaaaabbaaabaaabbabbabbbbaaabbababbabbabbaabaaaaabbabbbaaabbabbaaaabbabbbababababbaabababaaabaaababbbabbaabbbaaabaabbbbbbbaabbaaababbaaaaabbaabbaaaabbabaaaabbbaabbbbaabababbaabababbaabbbaaababaabbaaabbbabbbbaaaabbaabbabbaaababbbaabbbabbbabbaaabaabbaaabaaaaabbbabaaaababbbababbaaabbbaaabbbabbbabbaaabbabaabaaabbbbaabababbaababbbbabaaababbbbbaaabaaabbabbaaabbaabbaaabbbbbababaaaabbbaaaaaaaababbbaaabaaaababbbabababbabbbbbabaababbbbbbbbbabbbbababbabbbbbbabbaaaababbbaaababaaabbbbabbaaabbbaabbaaaaaabbbaabaabaabbabbbaaabbbbaaaaaaabaabbbabaaabbaaababbbbabbbbbabaaaabbabbababbabbbbbaabaabbbaaababbbbbbbaabbaaaabababaabbbbaaaabbaababbbbbbaaaabbaaabbaabaabbbbaaabababbabbbbbbbbaaaababaabbabbbababababbaabbabbabbbaababaabbabbaabbbbbbabbbbaaabbabaaaaabababbaabbaabbaaaaabaaabbaababbabaabbbabaaaaaababbabbbabbababaabaaaaaabbbabaaaaaaaaaababbbbbbbbbbaaabaaabbbbbbbbbbabaabbbaababaaababaabaabaababbbaaaabbbaabbbababaaaababababaaabbaabaabababbbbbabbaaabababaababaabbaaabaaaabababababbbabbabaaaaababbbbabaabababbaabaaaabbbbaabbabbbbabbbbabbbbbababbbbbbbbbaababbbbbababaaaabbabbaaabbaabaaaaabababbbbabbababbaaabbbbabbbbbbaabbabbaaabbabababaaaaabaabbbbbaabbbbabbaaabbbbbaaabaabababbbbbbbababaaaabaaaabbbbaaabababbbaabbaaaaabaabaabbabbaaaabbaaaabaaabbbbaaaaabbbbbbaabaaababbaabaaaabaaaaabbaaabbaaaaabbaabaaabbababbabbaabaabbabbbaabbaaabaaaabbabbbaaaabaababbabaabbaaabbaabbbbaabbaabbabbabaaaabbaabababbabbaababababaaaabbabbbbbabababbbaabbaaabbaabaabaaaaababbbaaabbbabaaabaabbaababbabbbaabaaabaabaaaabababbbbabaababababbabbbabbaaabbbaabbbbbbbbaabaabaaaaaababbbbabababbaabaaabbaaaaaaaaaababbaaaaabbaababbbabaabaabbabbabbabaaabaabbababaababbbababaabbabbbabaabbabaaaababaabababbaaaabbbbbbaaaabababaaababbbbabbbaaabaabbbbbbababbbbababbbbbabbbbaabbaaabbabaaaabaaabbbaaabbbbabbababbbababbaabbabbabbaaaabbbaabbbbbbabababbabaaabbbbaaabababbabbaabbbbbbaaababbbabaaaabbbababababbabbbababababbbbaabaaaaaababbabaaabbbbabbbabbbababbababbaaaababbbbaaaaabaaaaaaabaaaaabbaabbaabbbaababbbbbbbbbbaaabbaaaaabaaaaaaabbabbabaaabbbbabaaaabaaabbaaabbbababbabbbabaaababaabbbaabbaabbbaaabbabaaababbabbabbaabbbabaaabbabaaababaaaaabaababaaabbbbabbababbabbabaabbbbabbbaaabbaabababaabbaaababababaabbbbabaabbababababaaaabababbaabbbbaababbababbababaabbbaabbbbbabbbabbaaabbbaaabbbbbbbaababbabbabbabbaaabaabbaaabaaaabbbabbbaaabaabaababaaaabbaabbababbaabbbbbabaaaaaabbbaaaabaabbbaaaaaaaababaababaabbaabbaabbbabaabbaababbbabbbbaabaabbabbababaaaababbababbbaaaabaaaaaabaababbaaaabaabbbaaababbbabbbaabbbababbabaaaaaaaabbaabbbabbbabaababbaaaaabbbababbbaaabaaaabbbaabbbababaaaaaaaaabaaaaababbaabbababbabaabaaaabbbaabbaabbbbbaaaaabbbbaabbabaaababbbbbabbbbabbbbbabaaabaabbaababbbbbababaabbbbbaabbabbbabaaaababbabaabaaababbabbbabbaaaaabbababaabbbbbbabaaabbbaaabbbbbbbabaabaababaaaabbbaabbbaaaabbababaabbababbaabaaabbbbabaabbbabbbaabbbbbbbbbbabbbbbbbaaaabbababbbaababbbbbabbbbbbaabbaababbaaaabbbbaaaabbaaaaaaaaaaabbaaaaaaababaaaaaaabbbaabaabaaabababaaaaabbaabbbbabbabbaabaaabaabaaabbbbbaababababbaaaaabbababaabbbababbabbbabaabaaabaaaaababaabaabbbbabbabbbabbaabaabbbbaababaabbaababbabbbabbabaabaaabababaababaabbaabbababaababbababaabaaaaabbbbabbaabbaababaabaabaaababbabbababbabbaabaabbbbaabbbbbbbbbaaaabbabaabbababaabaabababbbbbbabbaabaaaababaababaaabbbaaaaabababababaababaaabaabaabbabbabbababababbaaaaabbbbbaaabbbbaaaabbabbabaaaababbbbabaaaaaababaaaabaabaaababbbbbbaaaabbabbbbabbabbabbbababbbbbababbbbbabababbaabbaabbabaaaaabbbabaabbababbbaabbaaababaaaaabbbbaabbaabbabaabbabbaaabaabaabbbaabababbabbaaabaabbbabaaaabaaaaaaaaaaabaabaaaaaaabaaababbbabbbaaaaaaaaaabbaabbbabbabaabaaaaaaabbabbaababbaabababbbabaabbbbaabaabbaaaabaaabaabaabbabaaaaabbbaabaababaaaaababababaaaaababaabbbbbbabaaaaaaaabaaaababbbbbbababaaabbbaaaababaaababbbaaabbababbaaaabbaababbbaabbaaaaaababbabbaaaababaabaababababbaaabababaabbbbbabababbaaaabbbabababbababbbbbaaaaabaaabbbbbbaabbbabababbabaabababbabaabaaaabaaaabbaaaabaabbaabaaababbbbaaabbaabaabaaabbaaabaabbaaabbaaaabbbbaabaaaababaabaaababbabbababbbaababbabbabaaaabbbaaaabbabaabaabbbabbbbbaaaabbbbabbbbbabaabababababbbbaabbbbbaaaabaabbbababbababababbbaabaabbbbbbbbabaabbabababaaabaaabaabaabbabbabababababababbbbbbaabaabbbaabbbaabbaaaaaaaaababbbababbbbbbbbbbabbaabbabbbababbbbbabaaaaabbaabbbbbbaaabbbababbbbaaababbbaabababaabbbaaaaabaabaaaababbaabbaabaabbaabbbaabbabbabbaaabbbabaaabbbbabbaabbaaaaaaabaaabaabaabaabbbababbbbbbbbbaaabaaabbbabbaabbabbbbbaabababaabaaaabaaabbabababbabababaaaabaabbababaababbbaaaabbbabbaabaabaabaababbbbaaabbaabbbaaabaaababaaaabbbaaababbbbabaabbaabbbaabaaabbbababaaabbabbaaaabbaaabbabbbabbbbabbbababaababaaaaabbbbbbaaaabaabbbaaabbababbabbbaabaaaaabaabaaaaabbbaabbbabbabaaaaabbbaabbbabaaaaaaaabbbbaaabaabaaaaabbabbaaaaaabbaaabbbbbaaaaaababaaabbaabbaabaaaababababaaabbabbaaabbaabaaabbaababbaabbbbabbbabbbababababaaabbababbbbaabaaaaabaaaabbbbaaabababbababbabbbaaababbaaaabaabbaaaababbbaaabaababaababbababbbaabaabbbbababaababaabaabbababbbaabbbaabaababbbbabbbababaabbabbbbaaaabbbbbbbabbbaaaaabbabaaabababbababbaaaabbaaabaaaabaaababaaababaaabbbaaaaaaaaabababaabbabbaabbbababaaabbbaaaaabbaaababbabbbbbbbaabaaababbbbbabaabbbaabbabbaabbbabbabbababbaaaaabababbbaaaaaaaabababaaaaaabababbbaabbbaaaaaabbababbbbbabbabbbaabbabbbabbabbabbbbbababbbbbbbbbaaabbaaaabaababaabbabbbbbababbaabbaababababaababbababbbbbbabbbaabaaabbaaaaabbaaabaabbbaaaabbbbababbaaaabaaabbbbbabaababbaabbbabaaaabaaaabaababaaaabaabaabbabaababaaaaaaaababbaaaaaaaaabbbabaaaababaaaaabbaababbbbbababbbabababbbababbbbaaababbaabbabbbaaaababbbbabbbaaababaabbbbbabbaaaabbbbbbababbbbabbbbabaaabbaaaaaaaabaaababbbbabbaaaabaaaabbabaabaabbabaaaabbaaabaabbabababaaabaaaaabaaabbbbbabbaabbbbabbbaaaaaabbabaabbabaaababbaaababbbabbbabaabbbbaaaaaabbaaaabbbabaababaabbbabbbaaaabbbbaabaaaaaaabababbbbbabbabbabbaabbbaaaabbaaabbabaaabbbaaaaaaaabbbbbaabbaabbaaaababbabaaabbabbaababaabbabaaaaabaababbbaaabbbaaababbbabababababbaababbbabababbbabababbbbaabaabbaabaaaaabbbbbababbaabababaababbaabbaababaaaaaaabbbbbababbbbbbbbababbababbabaaabababaabaabaaaaabbabaaabbbbabaaabbbaababaabbabaababaaaabababbabbbaabbbbbaaababbabaabbababbaabaababbbaaabbbaabbabaabbabbbaabaaabbaaabbabaaabaabbbaabaababbaaaabbaaaaabababbbababaabbbbaabaaaabbbaabbbbbaaaabaabaaaaaaababaaaababaaaabbbabbbababbbbbbaaaaaababaaabaabbaabbbaaabbaabaaabbabbbaaaaababbbbabbabbababbbbaaabbbbbabaababaaaaaabaaabbaaaabbababaaaaababbaabbbabbbbbaabaabbabababbbbaabababbbabbaababbababbababbababbbababbaaabbaababaaabbaaaaabbbbbbaaaabbabbaaabaaaabaababbaaaabaabaabbaabbaabbabbabbbabbaabbbababbaaaabbabbbbaaababbbbbbaabaaabbbaabaaaabbaaabbabbababababbababaaababbbbbaaaaaaabbabbababababaabbbaabababaaaababaaaabbbbabbbaaaabababaaaaaaaaaababbabababaaaaabbabbabbabaabbaaabbabababaababaaabbbbaaaaaababaababaaababbbbbabbaaabbbabaabbaababbbabaabbbbabbbaabbbbbbbaabbaabaaababaabbaababbaaabaabbbaaaabbbbbbaabbbbbaaabbaaabaabaabbbbbaaaaaaaaabbbbabbaababaaaaaaabbababbbbaabbabaabaaabababbabbabbaabbbabbbbaaaabbbaababbaababbaabbabbababbbbaababbabababbbbbaaabbbaaabaaaabbbaabbbaabbbbbbababaaabaaaabaabbabbbaaaabbaabaababaabbbbaabaabbaaaabaaaabbaaabbaabbabbbabaaaaaabbbaabaaaaabbaaaabbaababaabaabbaabbbabaaaabbbabbbbbaababaaaabaababaababbaabaabaabaaaababaaabbabaababaabbabbbaabbbaaababbbaaabbaaababaabaaaabbaaababbabbababaaababbabaaaaaabbbabaabbabbaaaabbababbabaabbabbbbabbbbaabbaabbabbaaaabbbababbabbaaababbbbabbaaaabbaabbabbabaabbaaabbbabbbbabababababbabaaabababbabbbbaaabaabaabbbabaaaaabaababbbaaabaabbaabbbbbbaaaabaababbbbbbbbabbbaaabbabbaaaabbbabaaaabbabbaaabaaaaabbaabbbaaabbaababbbbbaabbaaaabbaaaaababbbbaabababbbbabaabaaabbaaabbbaababbbabbababaabbaabaabababbaaababbabbababaaabbbaabaaabbaaaaabaabaababbaababbbbaabbbbbbbbabbbbababbabbbbbaababaabbabbbbaabbaabbaaabaaabababaabaabbbabbabaaaaababbbbbbbaabaabbbaabbabababbabbaabaaabbabaaaaaaaabaabaabbabaaaaaabbbababbbbababbabbbbbbaabaaaaaabaaaababbaaabbbabbabaaaabaabbbabaabbababbaaabaaabaabbaaaabbabbaaaabbaabaabbababbbaaababababbbaabbbbabaabaabbababaaaaaaaabbbbababbbbabaababaaaababababbbbbbaabaabaaaababaabaaabaaaabbbbbbbabaabbbaaaaaaabaaabbababbbaaabaaabaaaaabbbbbbaabbbabaabbbbaaaaabbaabbabbbabbabaaaabababbbabaaaabaabaabbbbaabaaaaaaabbaaabbaaabbaabbaabaaababaaaaabbaabbbaabaabbaababbabbbaababbabbabaaababaaaaaaaaababbabbbabaabbaabbbbabaababaaabbbaababaabbbabbaabababaabababbaaabbbaaaaabbbbbaaaaabaaabbbbaabbbbababbbbbbaabaaabbabbaabaabbbaabaababbaaaaaaaaaabbbaaabbbbaaaaaaababaaaabbaaabaaabaaaabbaababbbabbbbbaaabbaaabababaabbbababbababbbbbbaababaabbbbbbaaabaabbbaabbabaaabbabbaabbaaabbaabbaabbbababbbbababaaaabbbbbbabaabaaabbaababbbabaaaaaaababaaaabaabbbbaaabaabaaabbbbaaaaababababaabbbabaaaaabaabbbbaaababbaabbbbbbabaaaabbaaababbbbbbbbaabbabbabbbaaaaabbabbbbaababbaabaaabaaabababbbabbbbaaaabaaabaaabbaaabaaabbaabbaabababbbbbabbabaaabaabaabaaaabaabbbabbabbabbbbabbbbbabbbbbbaaaababbbaaabbbaababbbabaabbbabbaaaaaaabbabaaabaaaaabbbbbaaaaabbababaababbaabababbbbbbaaaabbbaabbbababaabaabaabbbbaaabaababbaabbabbaababaaabaababababbbabbbbaabbabaabababbabbabbaaabbabaababbaabbaaababbbbaaabbbbbaaabababababaabbbababbabaabbababababababbbaaaaaaaabababbabaabbbaaaaabbbabaaabbabaababaabbbababbbabbbbabaabaababababababbbbbbabbbbbabaaaaaababbabaaabbbbaaababaaaaabbbabbaabaababbbbaaabbbabbabaaabaaaabababbbabbaaabaabbbabbbabaabbabaabbbaabbbbbaabbbbbabababaabaaaabbbbbbaaaaabbbbbababbbbababbabaaaaaabaaaabbabbaaaabababbbabbbbbbbaabaaaaaaabaabbbababbaababbbbaabbbabbabbbaabbababababbabbbbaaaaabbbaabaaababbaaaaaaababaaabbbabaaababababbabaabababaabababaabbbbbababaabbbabaabbbbbaaaaaaabaababaabbaabaaaabaabbbbaabaabbabaabbbababaaababbbabbbbbbbbabbbbbaabbbbabbaaaaaaaabaabaababbaaabaaabaabaaaaaabaaaabbaaababbaaaabbbaaaaabbabbbabbbbaabbbaabbabbbbabbabaabbbabaaaabbababaabbbbbabbbbbbbbbbbbbbaabbababbbbbaababaabbabbabaaababbaabbaabaabbbbbababaabbbaaaaabbabbaababaaababbaabaaaaaabaabbbaaabaaaaaabaaaababbaabbbaabaaababaabbbbaabbbbaababbbaabbaabaaaabbbabaaaabbabaababaaaaabaaaabbaaaaabbbabbbbaabbbaaababbbbabbabbbbaabababababbbbbbaabbaaabbbabbabaaaaaabbbbbabababaaaababbaabbaabbbaaaaaabaaaaabbabbabbbbabbbaabaaaabaabaababbbbbbbbababbabaaabbbababbababaababaabbaaaabaaababaaabbabaaaaabaabaaababaaaababbbaabbaaabbbbbbbaabbbabbbbaaabbbbbbaaaabbaabaabbbbbbaaabbabbbaaabababbaaabbaaaaababbbaaabaabbaaabaaaabbbbbbbaaabbbbabbabbaaaaababbabbbbaaabaabaaabaabbababbababaabbabbaabababababbbabaaaaaaabaaabbaaaabbbabbbababbababaabaabbaa";
    private String pattern3 = "bababbababaabaabba";


    private BrutForceSubstringSearchAlgorithm brutForceSubstringSearchAlgorithm;
    private BrutForceSubstringSearchWithTextPreparationAlgorithm brutForceSubstringSearchWithTextPreparationAlgorithm;
    private KMPSubstringSearchAlgorithm kmpSubstringSearchAlgorithm;
    private KMPSubstringSearchWithTextPreparationAlgorithm kmpSubstringSearchWithTextPreparationAlgorithm;
    private BoyerMooreSubstringSearchAlgorithm boyerMooreSubstringSearchAlgorithm;
    private BoyerMooreSubstringSearchWithTextPreparationAlgorithm boyerMooreSubstringSearchWithTextPreparationAlgorithm;
    private RabinKarpSubstringSearchAlgorithm rabinKarpSubstringSearchAlgorithm;
    private RabinKarpSubstringSearchWithTextPreparationAlgorithm rabinKarpSubstringSearchWithTextPreparationAlgorithm;

    @Before
    public void setUp() {
        brutForceSubstringSearchAlgorithm = new BrutForceSubstringSearchAlgorithm();
        brutForceSubstringSearchWithTextPreparationAlgorithm = new BrutForceSubstringSearchWithTextPreparationAlgorithm();
        kmpSubstringSearchAlgorithm = new KMPSubstringSearchAlgorithm();
        kmpSubstringSearchWithTextPreparationAlgorithm = new KMPSubstringSearchWithTextPreparationAlgorithm();
        boyerMooreSubstringSearchAlgorithm = new BoyerMooreSubstringSearchAlgorithm();
        boyerMooreSubstringSearchWithTextPreparationAlgorithm = new BoyerMooreSubstringSearchWithTextPreparationAlgorithm();
        rabinKarpSubstringSearchAlgorithm = new RabinKarpSubstringSearchAlgorithm();
        rabinKarpSubstringSearchWithTextPreparationAlgorithm = new RabinKarpSubstringSearchWithTextPreparationAlgorithm();

    }

    @Test
    public void testPlainText() {
        test(text1, pattern1);
    }

    @Test
    public void testBiCharAlphBadCase() {
        test(text2, pattern2);
    }

    @Test
    public void testBiCharAlph() {
        test(text3, pattern3);
    }

    private void test(String text, String pattern) {
        brutForceSubstringSearchAlgorithm.setText(text);
        brutForceSubstringSearchWithTextPreparationAlgorithm.setText(text);
        kmpSubstringSearchAlgorithm.setText(text);
        kmpSubstringSearchWithTextPreparationAlgorithm.setText(text);
        boyerMooreSubstringSearchAlgorithm.setText(text);
        boyerMooreSubstringSearchWithTextPreparationAlgorithm.setText(text);
        rabinKarpSubstringSearchAlgorithm.setText(text);
        rabinKarpSubstringSearchWithTextPreparationAlgorithm.setText(text);
        Result b = brutForceSubstringSearchAlgorithm.search(pattern);
        Result kmp = kmpSubstringSearchAlgorithm.search(pattern);
        Result bm = boyerMooreSubstringSearchAlgorithm.search(pattern);
        Result rk = rabinKarpSubstringSearchAlgorithm.search(pattern);
        Result bwp = brutForceSubstringSearchWithTextPreparationAlgorithm.search(pattern);
        Result kmpwp = kmpSubstringSearchWithTextPreparationAlgorithm.search(pattern);
        Result bmwp = boyerMooreSubstringSearchWithTextPreparationAlgorithm.search(pattern);
        Result rkwp = rabinKarpSubstringSearchWithTextPreparationAlgorithm.search(pattern);

        System.out.println("Brut force  " + b.getIndex() + "     " + b.getTime());
        System.out.println("KMP         " + kmp.getIndex() + "     " + kmp.getTime());
        System.out.println("Boyer-Moore " + bm.getIndex() + "     " + bm.getTime());
        System.out.println("Rabin-Karp  " + rk.getIndex() + "     " + rk.getTime());
        System.out.println("With preparing");
        System.out.println("Brut force  " + bwp.getIndex() + "     " + bwp.getTime());
        System.out.println("KMP         " + kmpwp.getIndex() + "     " + kmpwp.getTime());
        System.out.println("Boyer-Moore " + bmwp.getIndex() + "     " + bmwp.getTime());
        System.out.println("Rabin-Karp  " + rkwp.getIndex() + "     " + rkwp.getTime());
    }


}