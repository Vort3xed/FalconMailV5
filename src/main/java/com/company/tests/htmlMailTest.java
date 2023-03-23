package com.company.tests;

import com.company.FalconMailCore;

public class htmlMailTest {
    public static void main(String[] args) throws Exception {
        new FalconMailCore().sendHTMLMail("htmlTest", """
                <p>Good {TIME_OF_DAY},</p>
                                
                <p>My name is {USER_NAME} and I'm a member of Poolesville Robotics Team 4099. <b>We're reaching out because we wanted to introduce our two summer camp opportunities to your school.</b> Known as FalconCamps and RoboCamps, these programs are designed to help students gain skills in math, engineering, and computer science through interactive sessions.</p>
                                
                <p>RoboCamps is a week-long in-person initiative at Clarksburg High School that teaches core STEM skills as campers learn how to design, build, and program a robot using pre-designed VEX IQ kits. This program culminates in a final competition so students can demonstrate their programming proficiency and concept understanding while competing for special prizes.</p>
                                
                <p>FalconCamps is a week-long online initiative that teaches mechanical design and/or programming in the context of competitive robotics, covering technical skills such as computer-aided design or object-oriented programming. This program prepares students to join a competitive robotics team and encourages them to pursue a future in STEM.</p>
                                
                <p>Currently, we are in the process of advertising and spreading the word about our opportunities. We would be very grateful if you would be willing to help us by advertising our programs to your students. More information may be found on the camps page of our website (https://www.team4099.com/programs/camps/), and I've attached an announcement blurb and our flyers below. In the past, schools have sent announcements or parent emails, but we are open to anything!</p>
                                
                <p>If you have any questions or concerns, feel free to reply to this email or contact the team at contact@team4099.com. </p>
                                
                <p>We look forward to hearing from you!</p>
                
                <p>{USER_NAME}</p>
                <p>Poolesville High School</p>
                <p>Team 4099</p>
                                
                                
                Sample Announcement:
                FIRST Robotics Team 4099 is hosting two summer camps this year: RoboCamps and FalconCamps!
                                
                RoboCamps is a week-long summer camp held at Clarksburg High School where students ages 8-14 learn how to design, build, and code their own robot. This interactive camp culminates in a final competition on the last day, where campers can show off their robots and compete for a special prize!
                                
                FalconCamps is a virtual one-week camp where experienced members of Team 4099 will teach robotics-focused mechanical design and/or programming. Middle or high schoolers living anywhere in the world can participate!
                                
                Click here to take a look at our programs’ website. If you or someone you know might be interested in either of these programs, registration is open! If you have any questions, feel free to email Team 4099 at contact@team4099.com.""");
    }
}
