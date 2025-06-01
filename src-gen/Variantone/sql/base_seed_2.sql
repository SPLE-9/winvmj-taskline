--
-- PostgreSQL database dump
--

-- Dumped from database version 17.4
-- Dumped by pg_dump version 17.4

-- Started on 2025-05-23 19:18:35

--
-- TOC entry 4996 (class 0 OID 39763)
-- Dependencies: 217
-- Data for Name: auth_role_comp; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO auth_role_comp VALUES ('8a5ea4fe-516b-4348-a266-3fa8a30b5b7a') ON CONFLICT DO NOTHING;
INSERT INTO auth_role_comp VALUES ('86ce4b40-b46c-4490-9fb2-ce8d2a242b22') ON CONFLICT DO NOTHING;


--
-- TOC entry 4997 (class 0 OID 39768)
-- Dependencies: 218
-- Data for Name: auth_role_impl; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO auth_role_impl VALUES ('administrator', 'Administrator', '8a5ea4fe-516b-4348-a266-3fa8a30b5b7a') ON CONFLICT DO NOTHING;
INSERT INTO auth_role_impl VALUES ('member', 'Member', '86ce4b40-b46c-4490-9fb2-ce8d2a242b22') ON CONFLICT DO NOTHING;


--
-- TOC entry 4998 (class 0 OID 39775)
-- Dependencies: 219
-- Data for Name: auth_user_comp; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO auth_user_comp VALUES ('60eba77e-cacb-4de3-9582-6f4fbeb56788') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp VALUES ('6a69b13c-219e-4fe0-9ff7-1cfa4a10e9c7') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp VALUES ('fcc19fe1-4420-4704-ab5f-e50f4b95852c') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp VALUES ('b0cdeaef-20e5-4e10-8388-8b748d5cd27f') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp VALUES ('9df7a1e3-9f40-4fc5-8b9a-c48694f29a30') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp VALUES ('77dac3da-1a89-4c77-95ce-65a1f7570f34') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp VALUES ('cf30936a-bf11-419f-9b2b-bf929dc363da') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp VALUES ('dd0631b3-dc22-4dae-b6c5-e4bc152946e6') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp VALUES ('dc572326-fa6b-484d-a529-9e0f1cfb1317') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp VALUES ('e550f65c-4d1a-441c-ac0c-1b20765f86cc') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp VALUES ('35528d98-dc96-4e12-be27-8823718449c2') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp VALUES ('0a23a6b5-9752-470c-a983-b81fc4d6963b') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp VALUES ('8c77cedd-54f0-4b75-9e31-8e4233805414') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp VALUES ('0dbf3835-3920-4da4-98fe-043c23d5de3f') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp VALUES ('810a7031-e048-4522-af58-b681503d5f39') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp VALUES ('4c4312b2-85e3-4a21-ba09-62df2ccfb4b4') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp VALUES ('97088b8b-7657-4e10-b869-f1d9c4da1a07') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp VALUES ('b375f443-eb2e-44e2-bd17-0192c33cd38a') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp VALUES ('73fcea48-f1a9-4205-9b45-1a746be70113') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp VALUES ('f03d7c83-cce4-4242-8c2c-6615563e473d') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp VALUES ('e61611da-47b5-4608-9c30-9a924c5f7ca6') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp VALUES ('3827caf8-ea54-4c32-8ec6-1e4a5324581a') ON CONFLICT DO NOTHING;


--
-- TOC entry 4999 (class 0 OID 39780)
-- Dependencies: 220
-- Data for Name: auth_user_impl; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO auth_user_impl VALUES ('', 'alex@user.com', 'Alex', '6a69b13c-219e-4fe0-9ff7-1cfa4a10e9c7') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_impl VALUES ('', 'brian@user.com', 'Brian', '77dac3da-1a89-4c77-95ce-65a1f7570f34') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_impl VALUES ('', 'chloe@user.com', 'Chloe', 'dd0631b3-dc22-4dae-b6c5-e4bc152946e6') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_impl VALUES ('', 'david@user.com', 'David', 'e550f65c-4d1a-441c-ac0c-1b20765f86cc') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_impl VALUES ('', 'emma@user.com', 'Emma', '0a23a6b5-9752-470c-a983-b81fc4d6963b') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_impl VALUES ('', 'felix@user.com', 'Felix', '0dbf3835-3920-4da4-98fe-043c23d5de3f') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_impl VALUES ('', 'grace@user.com', 'Grace', '4c4312b2-85e3-4a21-ba09-62df2ccfb4b4') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_impl VALUES ('', 'harry@user.com', 'Harry', 'b375f443-eb2e-44e2-bd17-0192c33cd38a') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_impl VALUES ('', 'isla@user.com', 'Isla', 'f03d7c83-cce4-4242-8c2c-6615563e473d') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_impl VALUES ('', 'jack@user.com', 'Jack', '3827caf8-ea54-4c32-8ec6-1e4a5324581a') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_impl VALUES ('administrator', 'admin@user.com', 'Admin', 'b0cdeaef-20e5-4e10-8388-8b748d5cd27f') ON CONFLICT DO NOTHING;


--
-- TOC entry 5000 (class 0 OID 39787)
-- Dependencies: 221
-- Data for Name: auth_user_passworded; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO auth_user_passworded VALUES ('349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b', '60eba77e-cacb-4de3-9582-6f4fbeb56788', '6a69b13c-219e-4fe0-9ff7-1cfa4a10e9c7') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_passworded VALUES ('349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b', 'fcc19fe1-4420-4704-ab5f-e50f4b95852c', 'b0cdeaef-20e5-4e10-8388-8b748d5cd27f') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_passworded VALUES ('349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b', '9df7a1e3-9f40-4fc5-8b9a-c48694f29a30', '77dac3da-1a89-4c77-95ce-65a1f7570f34') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_passworded VALUES ('349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b', 'cf30936a-bf11-419f-9b2b-bf929dc363da', 'dd0631b3-dc22-4dae-b6c5-e4bc152946e6') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_passworded VALUES ('349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b', 'dc572326-fa6b-484d-a529-9e0f1cfb1317', 'e550f65c-4d1a-441c-ac0c-1b20765f86cc') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_passworded VALUES ('349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b', '35528d98-dc96-4e12-be27-8823718449c2', '0a23a6b5-9752-470c-a983-b81fc4d6963b') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_passworded VALUES ('349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b', '8c77cedd-54f0-4b75-9e31-8e4233805414', '0dbf3835-3920-4da4-98fe-043c23d5de3f') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_passworded VALUES ('349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b', '810a7031-e048-4522-af58-b681503d5f39', '4c4312b2-85e3-4a21-ba09-62df2ccfb4b4') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_passworded VALUES ('349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b', '97088b8b-7657-4e10-b869-f1d9c4da1a07', 'b375f443-eb2e-44e2-bd17-0192c33cd38a') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_passworded VALUES ('349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b', '73fcea48-f1a9-4205-9b45-1a746be70113', 'f03d7c83-cce4-4242-8c2c-6615563e473d') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_passworded VALUES ('349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b', 'e61611da-47b5-4608-9c30-9a924c5f7ca6', '3827caf8-ea54-4c32-8ec6-1e4a5324581a') ON CONFLICT DO NOTHING;


--
-- TOC entry 5001 (class 0 OID 39792)
-- Dependencies: 222
-- Data for Name: auth_user_role_comp; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO auth_user_role_comp VALUES ('57ecf486-6252-4a67-94a9-f02b9d3c4f8f') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_comp VALUES ('383f71e2-7dd0-4820-807c-d206ea28ef98') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_comp VALUES ('15f2abb7-a551-48ec-bd6c-cf2d9928003f') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_comp VALUES ('e7ee893e-2ebb-45c5-8e12-4eb9f627f2fb') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_comp VALUES ('30671776-3173-4a23-b2cf-178610a69405') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_comp VALUES ('e4242db5-490e-46bb-b4c6-72be0ee80bd0') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_comp VALUES ('389a41dd-3236-47c3-af7b-18a6f2882a81') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_comp VALUES ('9c203be6-9e31-45d0-85d1-615783e04427') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_comp VALUES ('da9f2794-cd86-4bde-9437-a52d3f076622') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_comp VALUES ('d6bcbbc8-0e11-4f0b-ba7e-75666ba585c7') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_comp VALUES ('037b60a2-3964-447e-802f-6d0acef80435') ON CONFLICT DO NOTHING;


--
-- TOC entry 5002 (class 0 OID 39797)
-- Dependencies: 223
-- Data for Name: auth_user_role_impl; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO auth_user_role_impl VALUES ('57ecf486-6252-4a67-94a9-f02b9d3c4f8f', '8a5ea4fe-516b-4348-a266-3fa8a30b5b7a', 'b0cdeaef-20e5-4e10-8388-8b748d5cd27f') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_impl VALUES ('383f71e2-7dd0-4820-807c-d206ea28ef98', '86ce4b40-b46c-4490-9fb2-ce8d2a242b22', '6a69b13c-219e-4fe0-9ff7-1cfa4a10e9c7') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_impl VALUES ('15f2abb7-a551-48ec-bd6c-cf2d9928003f', '86ce4b40-b46c-4490-9fb2-ce8d2a242b22', '77dac3da-1a89-4c77-95ce-65a1f7570f34') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_impl VALUES ('e7ee893e-2ebb-45c5-8e12-4eb9f627f2fb', '86ce4b40-b46c-4490-9fb2-ce8d2a242b22', 'dd0631b3-dc22-4dae-b6c5-e4bc152946e6') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_impl VALUES ('30671776-3173-4a23-b2cf-178610a69405', '86ce4b40-b46c-4490-9fb2-ce8d2a242b22', 'e550f65c-4d1a-441c-ac0c-1b20765f86cc') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_impl VALUES ('e4242db5-490e-46bb-b4c6-72be0ee80bd0', '86ce4b40-b46c-4490-9fb2-ce8d2a242b22', '0a23a6b5-9752-470c-a983-b81fc4d6963b') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_impl VALUES ('389a41dd-3236-47c3-af7b-18a6f2882a81', '86ce4b40-b46c-4490-9fb2-ce8d2a242b22', '0dbf3835-3920-4da4-98fe-043c23d5de3f') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_impl VALUES ('9c203be6-9e31-45d0-85d1-615783e04427', '86ce4b40-b46c-4490-9fb2-ce8d2a242b22', '4c4312b2-85e3-4a21-ba09-62df2ccfb4b4') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_impl VALUES ('da9f2794-cd86-4bde-9437-a52d3f076622', '86ce4b40-b46c-4490-9fb2-ce8d2a242b22', 'b375f443-eb2e-44e2-bd17-0192c33cd38a') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_impl VALUES ('d6bcbbc8-0e11-4f0b-ba7e-75666ba585c7', '86ce4b40-b46c-4490-9fb2-ce8d2a242b22', 'f03d7c83-cce4-4242-8c2c-6615563e473d') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_impl VALUES ('037b60a2-3964-447e-802f-6d0acef80435', '86ce4b40-b46c-4490-9fb2-ce8d2a242b22', '3827caf8-ea54-4c32-8ec6-1e4a5324581a') ON CONFLICT DO NOTHING;


--
-- TOC entry 5003 (class 0 OID 39802)
-- Dependencies: 224
-- Data for Name: member_comp; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO member_comp VALUES ('8a1b1fc2-45c3-4f72-b180-1e20324f6010', 'alex@user.com', 'Alex', 'taskline.member.core.MemberImpl', 'member_impl') ON CONFLICT DO NOTHING;
INSERT INTO member_comp VALUES ('bfbc109a-2b89-4db4-8239-dfa9f0cf3db1', 'brian@user.com', 'Brian', 'taskline.member.core.MemberImpl', 'member_impl') ON CONFLICT DO NOTHING;
INSERT INTO member_comp VALUES ('f2791e4d-b9ec-413c-ae4a-89e98663cbd2', 'chloe@user.com', 'Chloe', 'taskline.member.core.MemberImpl', 'member_impl') ON CONFLICT DO NOTHING;
INSERT INTO member_comp VALUES ('6c58b9ee-b1d5-4f3f-bf5e-9f7a1e3d19c3', 'david@user.com', 'David', 'taskline.member.core.MemberImpl', 'member_impl') ON CONFLICT DO NOTHING;
INSERT INTO member_comp VALUES ('d0f3e134-82b3-4fa5-bb01-7b896dd27344', 'emma@user.com', 'Emma', 'taskline.member.core.MemberImpl', 'member_impl') ON CONFLICT DO NOTHING;
INSERT INTO member_comp VALUES ('73e3b5b4-2fa8-41b6-8e6d-26922a9efad5', 'felix@user.com', 'Felix', 'taskline.member.core.MemberImpl', 'member_impl') ON CONFLICT DO NOTHING;
INSERT INTO member_comp VALUES ('d44cb19a-9eb9-4c6a-8731-793790ecdd86', 'grace@user.com', 'Grace', 'taskline.member.core.MemberImpl', 'member_impl') ON CONFLICT DO NOTHING;
INSERT INTO member_comp VALUES ('37fae7c6-1a99-432a-a059-ebb4c0c79c39', 'harry@user.com', 'Harry', 'taskline.member.core.MemberImpl', 'member_impl') ON CONFLICT DO NOTHING;
INSERT INTO member_comp VALUES ('b5c021ed-2b5a-4bd9-9263-1247a0cf4e3c', 'isla@user.com', 'Isla', 'taskline.member.core.MemberImpl', 'member_impl') ON CONFLICT DO NOTHING;
INSERT INTO member_comp VALUES ('c6e15d63-d6c5-4d85-84fd-b5fef0ff318f', 'jack@user.com', 'Jack', 'taskline.member.core.MemberImpl', 'member_impl') ON CONFLICT DO NOTHING;


--
-- TOC entry 5004 (class 0 OID 39809)
-- Dependencies: 225
-- Data for Name: member_impl; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO member_impl VALUES ('8a1b1fc2-45c3-4f72-b180-1e20324f6010') ON CONFLICT DO NOTHING;
INSERT INTO member_impl VALUES ('bfbc109a-2b89-4db4-8239-dfa9f0cf3db1') ON CONFLICT DO NOTHING;
INSERT INTO member_impl VALUES ('f2791e4d-b9ec-413c-ae4a-89e98663cbd2') ON CONFLICT DO NOTHING;
INSERT INTO member_impl VALUES ('6c58b9ee-b1d5-4f3f-bf5e-9f7a1e3d19c3') ON CONFLICT DO NOTHING;
INSERT INTO member_impl VALUES ('d0f3e134-82b3-4fa5-bb01-7b896dd27344') ON CONFLICT DO NOTHING;
INSERT INTO member_impl VALUES ('73e3b5b4-2fa8-41b6-8e6d-26922a9efad5') ON CONFLICT DO NOTHING;
INSERT INTO member_impl VALUES ('d44cb19a-9eb9-4c6a-8731-793790ecdd86') ON CONFLICT DO NOTHING;
INSERT INTO member_impl VALUES ('37fae7c6-1a99-432a-a059-ebb4c0c79c39') ON CONFLICT DO NOTHING;
INSERT INTO member_impl VALUES ('b5c021ed-2b5a-4bd9-9263-1247a0cf4e3c') ON CONFLICT DO NOTHING;
INSERT INTO member_impl VALUES ('c6e15d63-d6c5-4d85-84fd-b5fef0ff318f') ON CONFLICT DO NOTHING;


--
-- TOC entry 5005 (class 0 OID 39814)
-- Dependencies: 226
-- Data for Name: project_comp; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO project_comp VALUES ('533bdcc7-9def-4395-a934-3f6d24f6fdb7', 0, '<p>A full overhaul of the corporate website to improve user experience and responsiveness.</p>', 'taskline.project.core.ProjectComponent', 'Website Redesign', 'project_impl') ON CONFLICT DO NOTHING;
INSERT INTO project_comp VALUES ('3be538eb-04cb-48b6-acb2-58ce9578d04a', 0, '<p>Development and release of a new mobile application for our e-commerce platform.</p>', 'taskline.project.core.ProjectComponent', 'Mobile App Launch', 'project_impl') ON CONFLICT DO NOTHING;
INSERT INTO project_comp VALUES ('638a6dc8-c915-49cc-aef3-bf454267c0fd', 0, '<p>Launch and monitor a digital marketing campaign for Q3 sales boost.</p>', 'taskline.project.core.ProjectComponent', 'Marketing Campaign Q3', 'project_impl') ON CONFLICT DO NOTHING;


--
-- TOC entry 5006 (class 0 OID 39821)
-- Dependencies: 227
-- Data for Name: project_impl; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO project_impl VALUES ('533bdcc7-9def-4395-a934-3f6d24f6fdb7') ON CONFLICT DO NOTHING;
INSERT INTO project_impl VALUES ('3be538eb-04cb-48b6-acb2-58ce9578d04a') ON CONFLICT DO NOTHING;
INSERT INTO project_impl VALUES ('638a6dc8-c915-49cc-aef3-bf454267c0fd') ON CONFLICT DO NOTHING;


--
-- TOC entry 5007 (class 0 OID 39826)
-- Dependencies: 228
-- Data for Name: projectmember_comp; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 5008 (class 0 OID 39831)
-- Dependencies: 229
-- Data for Name: projectmember_impl; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 5009 (class 0 OID 39836)
-- Dependencies: 230
-- Data for Name: task_comp; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO task_comp VALUES ('646284dc-d397-436d-b2cf-f1814590f788', NULL, '2025-05-23 18:58:35.071', 'Design basic wireframes for homepage and major landing pages.', 'taskline.task.core.TaskComponent', 0, 'Wireframe Creation', NULL, '533bdcc7-9def-4395-a934-3f6d24f6fdb7', 'task_impl') ON CONFLICT DO NOTHING;
INSERT INTO task_comp VALUES ('d2741a87-fda6-4012-bc6b-6e0e0f5eea60', NULL, '2025-05-23 18:58:54.715', 'Implement HTML, CSS, and JS for responsive layout and styling.', 'taskline.task.core.TaskComponent', 0, 'Frontend Development', NULL, '533bdcc7-9def-4395-a934-3f6d24f6fdb7', 'task_impl') ON CONFLICT DO NOTHING;
INSERT INTO task_comp VALUES ('b7ee8fbd-acec-4c8a-a87a-e29052059aa0', NULL, '2025-05-23 18:59:10.181', 'Move content from the old site to the new CMS with updated formatting.', 'taskline.task.core.TaskComponent', 0, 'Content Migration', NULL, '533bdcc7-9def-4395-a934-3f6d24f6fdb7', 'task_impl') ON CONFLICT DO NOTHING;
INSERT INTO task_comp VALUES ('f69dced1-bdc4-4a50-80e8-ff0c9fcfd497', NULL, '2025-05-23 18:59:33.93', 'Create mobile-first UI mockups for both Android and iOS platforms.', 'taskline.task.core.TaskComponent', 0, 'UI Design', NULL, '3be538eb-04cb-48b6-acb2-58ce9578d04a', 'task_impl') ON CONFLICT DO NOTHING;
INSERT INTO task_comp VALUES ('4218b255-a4d3-4ac4-b980-7e935f3e5f3a', NULL, '2025-05-23 18:59:50.475', 'Connect mobile app to backend services using RESTful APIs.', 'taskline.task.core.TaskComponent', 0, 'API Integration', NULL, '3be538eb-04cb-48b6-acb2-58ce9578d04a', 'task_impl') ON CONFLICT DO NOTHING;
INSERT INTO task_comp VALUES ('22cc5949-8e33-4beb-9361-e2102b041066', NULL, '2025-05-23 19:00:09.325', 'Conduct closed beta testing and gather user feedback for improvements.', 'taskline.task.core.TaskComponent', 0, 'Beta Testing', NULL, '3be538eb-04cb-48b6-acb2-58ce9578d04a', 'task_impl') ON CONFLICT DO NOTHING;
INSERT INTO task_comp VALUES ('df2ac3d4-a856-4c8c-ba8c-1fab293d632c', NULL, '2025-05-23 19:00:34.736', 'Define campaign objectives, audience targeting, and key messages.', 'taskline.task.core.TaskComponent', 0, 'Campaign Strategy', NULL, '638a6dc8-c915-49cc-aef3-bf454267c0fd', 'task_impl') ON CONFLICT DO NOTHING;
INSERT INTO task_comp VALUES ('61e010bf-c26a-41b3-b09c-82119fab87dd', NULL, '2025-05-23 19:00:49.965', 'Design creative assets for Google Ads, Facebook, and Instagram.', 'taskline.task.core.TaskComponent', 0, 'Ad Creation', NULL, '638a6dc8-c915-49cc-aef3-bf454267c0fd', 'task_impl') ON CONFLICT DO NOTHING;
INSERT INTO task_comp VALUES ('2a26f96b-3237-4b3c-bf17-b99fc74d6946', NULL, '2025-05-23 19:01:05.23', 'Set up tracking and analytics to measure campaign effectiveness.', 'taskline.task.core.TaskComponent', 0, 'Performance Tracking', NULL, '638a6dc8-c915-49cc-aef3-bf454267c0fd', 'task_impl') ON CONFLICT DO NOTHING;


--
-- TOC entry 5010 (class 0 OID 39843)
-- Dependencies: 231
-- Data for Name: task_impl; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO task_impl VALUES ('646284dc-d397-436d-b2cf-f1814590f788') ON CONFLICT DO NOTHING;
INSERT INTO task_impl VALUES ('d2741a87-fda6-4012-bc6b-6e0e0f5eea60') ON CONFLICT DO NOTHING;
INSERT INTO task_impl VALUES ('b7ee8fbd-acec-4c8a-a87a-e29052059aa0') ON CONFLICT DO NOTHING;
INSERT INTO task_impl VALUES ('f69dced1-bdc4-4a50-80e8-ff0c9fcfd497') ON CONFLICT DO NOTHING;
INSERT INTO task_impl VALUES ('4218b255-a4d3-4ac4-b980-7e935f3e5f3a') ON CONFLICT DO NOTHING;
INSERT INTO task_impl VALUES ('22cc5949-8e33-4beb-9361-e2102b041066') ON CONFLICT DO NOTHING;
INSERT INTO task_impl VALUES ('df2ac3d4-a856-4c8c-ba8c-1fab293d632c') ON CONFLICT DO NOTHING;
INSERT INTO task_impl VALUES ('61e010bf-c26a-41b3-b09c-82119fab87dd') ON CONFLICT DO NOTHING;
INSERT INTO task_impl VALUES ('2a26f96b-3237-4b3c-bf17-b99fc74d6946') ON CONFLICT DO NOTHING;


-- Completed on 2025-05-23 19:18:35

--
-- PostgreSQL database dump complete
--

