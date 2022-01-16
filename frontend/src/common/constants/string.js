import { CATEGORY_IMG } from 'assets/img';

const NAV_BAR_LOGIN = '로그인';
const NAV_BAR_LOGOUT = '로그아웃';
const NAV_BAR_SIGN_UP = '회원가입';
const NAV_BAR_SETTING = '설정';

const CATEGORIES = [
  { name: 'TEXT TILE', img: CATEGORY_IMG.TEXT_TILE },
  { name: 'PRINTS', img: CATEGORY_IMG.PRINTS },
  { name: 'SCULPTURE', img: CATEGORY_IMG.SCULPTURE },
  { name: 'COLLAGES', img: CATEGORY_IMG.COLLAGES },
  { name: 'JEWELRY', img: CATEGORY_IMG.JEWELRY },
  { name: 'PHOTOGRAPHY', img: CATEGORY_IMG.PHOTO },
  { name: 'GRAPHIC DESIGN', img: CATEGORY_IMG.GRAPHICDESIGN },
  { name: 'PAINTING', img: CATEGORY_IMG.PAINTING },
  { name: 'ILLUSTRATION', img: CATEGORY_IMG.ILLUSTRATION },
  { name: 'WORK ON PAPER', img: CATEGORY_IMG.WORK_ON_PAPER }
];

export {
  NAV_BAR_LOGIN,
  NAV_BAR_LOGOUT,
  NAV_BAR_SIGN_UP,
  NAV_BAR_SETTING,
  CATEGORIES
};
