package com.example.rkjc.news_app_2;

import com.example.rkjc.news_app_2.utils.JsonUtils;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertTrue;

public class JSONTest {

    String testString = "{\"status\":\"ok\",\"source\":\"the-next-web\",\"sortBy\":\"top\",\"articles\":[{\"author\":\"Matthew Hughes\",\"title\":\"IBM's acquisition of Red Hat is massive for the Linux world\",\"description\":\"IBM today announced it would be acquiring iconic Linux firm Red Hat in a $34 billion all-cash deal.\\r\\n\\r\\nAccording to a joint statement issued by both companies, IBM will pay $190 for ...\",\"url\":\"https://thenextweb.com/dd/2018/10/28/ibms-acquisition-of-red-hat-is-huge-news-for-the-linux-world/\",\"urlToImage\":\"https://img-cdn.tnwcdn.com/image/tnw?filter_last=1&fit=1280%2C640&url=https%3A%2F%2Fcdn0.tnwcdn.com%2Fwp-content%2Fblogs.dir%2F1%2Ffiles%2F2018%2F10%2Fsai-kiran-anagani-555972-unsplash.jpg&signature=fac12194567b8abcb20b2f7ea78eb3de\",\"publishedAt\":\"2018-10-28T22:09:09Z\"},{\"author\":\"TNW Deals\",\"title\":\"Tableau cracks the business data code...be a data scientist now for just $19\",\"description\":\"If you want to know the Rosetta Stone that top companies use to reach their most intricate, data-driven decisions, look no further than Tableau. While it doesn&rsquo;t pop out ...\",\"url\":\"https://thenextweb.com/offers/2018/10/28/tableau-cracks-the-business-data-code-be-a-data-scientist-now-for-just-19/\",\"urlToImage\":\"https://img-cdn.tnwcdn.com/image/tnwDeals?filter_last=1&fit=1280%2C640&url=https%3A%2F%2Fcdn0.tnwcdn.com%2Fwp-content%2Fblogs.dir%2F1%2Ffiles%2F2018%2F10%2Fd8lMFdV.jpg&signature=515aaf3ff95453c55b0cb01d5f6df59d\",\"publishedAt\":\"2018-10-28T14:00:00Z\"},{\"author\":\"Andrew Akesson\",\"title\":\"3 handy features in Google For Jobs to measure your hiring campaign’s success\",\"description\":\"Google For Jobs has made a great impact on the jobs market ever since it was released by the search giant in June 2017. There’s been tons written on the feature since it came out, but it’s still a new product and many users are still figuring out how to get the most out of …\",\"url\":\"https://thenextweb.com/contributors/2018/10/27/3-handy-features-in-google-for-jobs-to-measure-your-hiring-campaigns-success/\",\"urlToImage\":\"https://img-cdn.tnwcdn.com/image/tnw?filter_last=1&fit=1280%2C640&url=https%3A%2F%2Fcdn0.tnwcdn.com%2Fwp-content%2Fblogs.dir%2F1%2Ffiles%2F2018%2F10%2F3-handy-features-in-Google-For-Jobs-to-measure-your-hiring-campaign%E2%80%99s-success.png&signature=d22441c0043aa64eadce1b8b3823f6d9\",\"publishedAt\":\"2018-10-26T15:16:01Z\"},{\"author\":\"TNW Deals\",\"title\":\"Here’s how you get certified to run the most important IT areas in business\",\"description\":\"2019 is barreling toward us like a freight train. For those thinking about dumping their current dead-end jobs for new careers, these pre-holiday weeks are prime time for getting those ...\",\"url\":\"https://thenextweb.com/offers/2018/10/27/heres-how-you-get-certified-to-run-the-most-important-it-areas-in-business/\",\"urlToImage\":\"https://img-cdn.tnwcdn.com/image/tnwDeals?filter_last=1&fit=1280%2C640&url=https%3A%2F%2Fcdn0.tnwcdn.com%2Fwp-content%2Fblogs.dir%2F1%2Ffiles%2F2018%2F10%2FupCMY9o.jpg&signature=8a967c05cc59c4a02045164e02555ab6\",\"publishedAt\":\"2018-10-27T14:00:00Z\"},{\"author\":\"Glen Ford\",\"title\":\"4 human-caused biases we need to fix for machine learning\",\"description\":\"Bias is an overloaded word. It has multiple meanings, from mathematics to sewing to machine learning, and as a result it’s easily misinterpreted.\\r\\n\\r\\nWhen people say an AI model is ...\",\"url\":\"https://thenextweb.com/contributors/2018/10/27/4-human-caused-biases-machine-learning/\",\"urlToImage\":\"https://img-cdn.tnwcdn.com/image/tnw?filter_last=1&fit=1280%2C640&url=https%3A%2F%2Fcdn0.tnwcdn.com%2Fwp-content%2Fblogs.dir%2F1%2Ffiles%2F2018%2F10%2F4-human-caused-biases-we-need-to-fix-for-machine-learning1.png&signature=c982c71832576213236073edf7b595a0\",\"publishedAt\":\"2018-10-26T09:25:43Z\"},{\"author\":\"Phillip Mintchin\",\"title\":\"London is making life way too hard for mobility tech companies\",\"description\":\"The urban mobility market has come a long way since London’s first horse drawn bus service in 1829. Even in the last five years, the rise of digitally-enabled ride-hailing mobility solutions such as Uber or ViaVan, or dockless on-demand mobility solutions such as Ofo and Mobike have significantly changed how Londoners get around. However, with …\",\"url\":\"https://thenextweb.com/contributors/2018/10/27/london-is-making-life-way-too-hard-for-mobility-tech-companies/\",\"urlToImage\":\"https://img-cdn.tnwcdn.com/image/tnw?filter_last=1&fit=1280%2C640&url=https%3A%2F%2Fcdn0.tnwcdn.com%2Fwp-content%2Fblogs.dir%2F1%2Ffiles%2F2018%2F10%2Flondon-530055_1920.jpg&signature=fe4ad81a27b0bb315a9a79f6d41dfe0d\",\"publishedAt\":\"2018-10-26T15:39:55Z\"},{\"author\":\"Rachel Kaser\",\"title\":\"Twitch debuts group streaming and karaoke at TwitchCon\",\"description\":\"Twitch today revealed a plethora of new features for streamers and viewers, as part of the first day of its TwitchCon celebrations. CEO Emmett Shear led the Day One keynote, revealing the new features to the attendees. Some were niche — such as the better moderation tools, and the ability to designate some viewers as VIPs …\",\"url\":\"https://thenextweb.com/tech/2018/10/26/twitch-group-streaming-karaoke/\",\"urlToImage\":\"https://img-cdn.tnwcdn.com/image/tnw?filter_last=1&fit=1280%2C640&url=https%3A%2F%2Fcdn0.tnwcdn.com%2Fwp-content%2Fblogs.dir%2F1%2Ffiles%2F2018%2F10%2FTwitch-Sings-Karaoke.jpg&signature=b244446fb3b4e8413c8baa058636aad7\",\"publishedAt\":\"2018-10-26T23:02:55Z\"},{\"author\":\"Tristan Greene\",\"title\":\"Vankyo’s Android mini-projector is a date night delight\",\"description\":\"The Vankyo M50 Passport DLP mini-projector is an Android-powered gadget that can project on just about any flat surface. It’s pocket-sized, so I smuggled a review unit home to see what it could do. The M50 Passport is an immediately accessible gadget. It’s small – about the size of a passport, hence the name – […]\",\"url\":\"https://thenextweb.com/plugged/2018/10/26/vankyos-android-mini-projector-is-a-date-night-delight/\",\"urlToImage\":\"https://img-cdn.tnwcdn.com/image/plugged?filter_last=1&fit=1280%2C640&url=https%3A%2F%2Fcdn0.tnwcdn.com%2Fwp-content%2Fblogs.dir%2F1%2Ffiles%2F2018%2F10%2Ffeatured-1.jpg&signature=b530d8db398fda7cb3d62a1567c58d1d\",\"publishedAt\":\"2018-10-26T22:29:14Z\"},{\"author\":\"Gary Eastwood\",\"title\":\"Is Tim Cook the champion of privacy?\",\"description\":\"Today’s ceaseless data scandals have everyone talking about privacy, especially insofar as our favorite digital devices and platforms are concerned. Few companies have been at the ...\",\"url\":\"https://thenextweb.com/contributors/2018/10/26/is-tim-cook-the-champion-of-privacy/\",\"urlToImage\":\"https://img-cdn.tnwcdn.com/image/tnw?filter_last=1&fit=1280%2C640&url=https%3A%2F%2Fcdn0.tnwcdn.com%2Fwp-content%2Fblogs.dir%2F1%2Ffiles%2F2018%2F10%2Ftimcookprivacy.jpg&signature=95e0e75814fb6bf2c97bde168d04d2a8\",\"publishedAt\":\"2018-10-26T22:18:57Z\"},{\"author\":\"Rachel Kaser\",\"title\":\"Library of Congress says video game museums are legal -- to a point\",\"description\":\"A decision from the Librarian of Congress and the US Copyright Office, handed down earlier this week, could mean older games can now legally be saved by video game historians and archivists ...\",\"url\":\"https://thenextweb.com/gaming/2018/10/26/library-of-congress-video-game-preservation-historian-museums-copyright/\",\"urlToImage\":\"https://img-cdn.tnwcdn.com/image/tnw?filter_last=1&fit=1280%2C640&url=https%3A%2F%2Fcdn0.tnwcdn.com%2Fwp-content%2Fblogs.dir%2F1%2Ffiles%2F2018%2F10%2FJoystick.jpg&signature=2dbd45afb0531d739b4c30466fa0c56a\",\"publishedAt\":\"2018-10-26T19:04:53Z\"}]}";

    @Test
    public void parseJSONReturnsNonEmptyList(){
        ArrayList<NewsItem> items = JsonUtils.parseNews(testString);
        assertTrue(!items.isEmpty());
    }

    @Test
    public void parseJSONReturnsValidList(){
        ArrayList<NewsItem> items = JsonUtils.parseNews(testString);
        NewsItem newsItem = items.get(0);

        assertTrue(newsItem.getTitle().equals("IBM's acquisition of Red Hat is " +
                "massive for the Linux world"));
        assertTrue(newsItem.getDescription().contains("IBM today announced it would be acquiring " +
                "iconic Linux firm Red Hat in a $34 billion all-cash deal."));
        assertTrue(newsItem.getUrl().equals("https://thenextweb.com/dd/2018/10/28/ibms-acquisition-of-red-hat-is-huge-news-for-the-linux-world/"));
    }
}
